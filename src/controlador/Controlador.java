
package controlador;


import conexion.Conexion;
import dao.DaoAsistencia;
import vista.Editar.UsuEditar;
import vista.Editar.Escolar_Editar;
import dao.DaoBeneficiario;
import dao.DaoCurso;
import dao.DaoMama;
import dao.DaoPapa;
import dao.DaoPadres;
import dao.DaoSocioEconomico;
import dao.DaoEscolaridad;
import dao.DaoFicha;
import dao.DaoUsuario;
import idao.IAsistencia;
import idao.ICurso;
import idao.IFicha;
import idao.ISocioEconomico;
import idao.IUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import modelo.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import vista.*;
import vista.Editar.BeneFiltro;
import vista.Editar.CursoEditar;
import vista.Editar.DatosEditar;

/**
 *
 * @author Mady
 */
public class Controlador extends Conexion implements ActionListener, FocusListener, MouseListener {

    ArrayList<Object[]> datos = new ArrayList<>();
    ArrayList<Object[]> datosm = new ArrayList<>();
    ArrayList<Object[]> datosp = new ArrayList<>();
    String COLUM[] = {"Id", "Usuario", "Contraseña", "Tipo", "Estado"};
    DefaultTableModel modelo = new DefaultTableModel(COLUM, 0);
    String COLUMCurso[] = {"Id", "Nombre", "Estado"};
    DefaultTableModel modelocurso = new DefaultTableModel(COLUMCurso, 0);
    boolean valor;

    String COLUMBenefi[] = {"Cédula", "Nombre", "Apellido", "Padre", "Madre", "Dirección", "Telefono"};
    DefaultTableModel modeloBenefi;
    
    String COLUMPadres[] = {"Id", "nombre", "Estado civil", "Lugar Trabajo", "Cargo", "Telefono"};
    DefaultTableModel modeloPadres = new DefaultTableModel(COLUMPadres, 0);

    DefaultTableModel modelEscolaridad;

    //Vistas
    private final Crear_NuevoUsuario vistNuevUsu = new Crear_NuevoUsuario();
    private final List_Usuario vistListUsu = new List_Usuario();
    private final Inicio vistInicio = new Inicio();
    private final UsuDatos vistDatosUsu = new UsuDatos();
    private final UsuEditar vistEditarUsu = new UsuEditar();
    private final Menu_Principal vistMenu = new Menu_Principal();
        private final Menu_Mantenedor vistMenuMantenedor = new Menu_Mantenedor();
    private final Registrar_Asistencia vistRegistAsis = new Registrar_Asistencia();
    private final Registro_Curso vistRegistCurso = new Registro_Curso();
//    private final Asistencia_General vistAsisGeneral = new Asistencia_General();
   
    private final Reports2 reports = new Reports2();
    private final Crear_NuevoCurso vistCrearCurso = new Crear_NuevoCurso();
    private final CursoEditar vistEditarCurso = new CursoEditar();

    private final Ins_Personal crearbene = new Ins_Personal();
    private final Lista_Beneficiarios vistBeneficiarioLis = new Lista_Beneficiarios();
    private final DatosEditar vistEditarDatos = new DatosEditar();
    private final Ins_DatoEscolar vistInsDatEscolar = new Ins_DatoEscolar();
    private final Escolar_Editar vistEscolar_Editar = new Escolar_Editar();
    private final ListaDatosEscolar vistaListaDatoEscolar = new ListaDatosEscolar();
    private final Ins_Curso_per vistCursoPer = new Ins_Curso_per();
    private final Ins_DatoPadre vistIngPadre = new Ins_DatoPadre();
    private final Ins_DatoMadre vistIngMadre = new Ins_DatoMadre();
    private final Ins_DatoSocialesEco vistInsDatSocioEco = new Ins_DatoSocialesEco();

    private final BeneFiltro vistBeneFiltro = new BeneFiltro();
    
//    private List_Padres vistListPadres = new List_Padres();
    Reg_Escolar editarescolar;

    //Modelos
    private Usuario usuarioEdit;
    private Usuario usuario;
    private CursoEntity curspEdit;
    private CursoEntity curso;

    private Padres modpadres = new Padres();
    private Mama modeMa = new Mama();
    private Papa modePa = new Papa();
    private Reg_Escolar escolar = new Reg_Escolar();
    private Reg_dataSocial datosSociales = new Reg_dataSocial();

    Reg_Benf beneficiario = new Reg_Benf();
    
    public Controlador() { }

    public void iniciarVista() {
        vistInicio.btnIngresar.addActionListener(this);
        vistInicio.pack();
        vistInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vistInicio.setVisible(true);

        vistMenu.getjLblSalir().addMouseListener(this);

        vistMenu.jBttn_DatosUsuario.addActionListener(this);
        vistDatosUsu.getjBtn_VerListaUsu().addActionListener(this);
        vistDatosUsu.getjLblRetroceder().addMouseListener(this);
        vistListUsu.getjButton_AgregarUsu().addActionListener(this);
        vistListUsu.getjButton_EditarDatos1().addActionListener(this);
        vistListUsu.getjLblRetroceder().addMouseListener(this);
        vistNuevUsu.getJbtn_guardarUsu().addActionListener(this);
        vistNuevUsu.getjLblRetroceder().addMouseListener(this);
        vistEditarUsu.getjBtn_Modificar().addActionListener(this);
        vistEditarUsu.getjLblRetroceder().addMouseListener(this);
        
        vistMenu.jBttn_Mantenedor.addActionListener(this);
        vistMenuMantenedor.getjLblSalir().addMouseListener(this);
        vistMenuMantenedor.jBttn_Cursos.addActionListener(this);

        vistMenu.jBttn_Registro.addActionListener(this);
        vistRegistAsis.getJbtn_guardar().addActionListener(this);
        vistRegistAsis.getJbtn_editarCurso().addActionListener(this);
        vistRegistAsis.getJbtn_GenerarReporteEnPdf().addActionListener(this);

        vistRegistAsis.getjLblRetroceder().addMouseListener(this);
        vistRegistCurso.Jbtn_agrCurso.addActionListener(this);
        vistCrearCurso.Jbtn_inscCurso.addActionListener(this);
        vistCrearCurso.getjLblRetroceder().addMouseListener(this);
        vistRegistCurso.getJbtn_guardar().addActionListener(this);
        vistRegistCurso.getjLblRetroceder().addMouseListener(this);
        
        vistRegistAsis.getjCmbBMaterias().addActionListener(this);
        
        //--
        reports.getjButtonGenerarReportsss().addActionListener(this);
        //--
        
//        vistAsisGeneral.getjBttnGuardarForm().addActionListener(this);
//        vistAsisGeneral.getjBttnCerrarForm().addActionListener(this);

        vistMenu.jBttn_Beneficiarios.addActionListener(this);
        crearbene.getjLblRetroceder().addMouseListener(this);
        crearbene.getJbtn_datoEconomicos().addActionListener(this);
        vistIngPadre.getJbtn_datosEscolares().addActionListener(this);
        vistIngPadre.getJRB_madre().addFocusListener(this);
        vistIngPadre.getJRB_padre().addFocusListener(this);
        vistIngMadre.getJRB_madre().addFocusListener(this);
        vistIngMadre.getJRB_padre().addFocusListener(this);
        vistIngMadre.getJbtn_datosEscolares().addActionListener(this);

        vistCursoPer.getjLblRetroceder().addMouseListener(this);
        vistCursoPer.getjBttnBuscarCurso().addActionListener(this);
        vistCursoPer.getjBttnGuardarCurso().addActionListener(this);

        vistInsDatSocioEco.getJbtn_guardarDatosSoeco().addActionListener(this);

        vistInsDatEscolar.getJbtn_guardarDatosFinal().addActionListener(this);
        vistInsDatEscolar.getBtnVisualizarTabla().addActionListener(this);
        vistInsDatEscolar.getJRB_primaria().addFocusListener(this);
        vistInsDatEscolar.getJRB_secundaria().addFocusListener(this);
        vistaListaDatoEscolar.getBtnRegresar().addActionListener(this);
        vistaListaDatoEscolar.getjBtn_EditarDatos().addActionListener(this);
        vistEscolar_Editar.getJbtn_modificarDtoEscol().addActionListener(this);

        vistBeneficiarioLis.getjLblRetroceder().addMouseListener(this);
        vistBeneficiarioLis.getjBttn_editarBenef().addActionListener(this);
        vistEditarDatos.getjLblRetroceder().addMouseListener(this);
        vistEditarDatos.getJbtn_guardarEdit().addActionListener(this);
        vistEditarDatos.getJRB_primaria().addFocusListener(this);
        vistEditarDatos.getJRB_secundaria().addFocusListener(this);
        vistBeneficiarioLis.getjBttn_AgregarBenefi().addActionListener(this);
        vistBeneficiarioLis.getjBttn_asignarCurso().addActionListener(this);
        vistBeneficiarioLis.getJBTN_exportarPDF().addActionListener(this);

        vistBeneFiltro.getjBtn_GenerarPdf().addActionListener(this);

//        vistListPadres.getjButton_AgregarPadr().addActionListener(this);
//        vistListPadres.getjButton_EditarDatos().addActionListener(this);
//        vistListPadres.getjButton_Consultar().addActionListener(this);
        vistEditarCurso.getjBtn_ModificarCurso().addActionListener(this);
        vistEditarCurso.getjLblRetroceder().addMouseListener(this);
        vistRegistAsis.getJbtn_BuscarAsistencia().addActionListener(this);
        
        vistRegistAsis.getJbtn_ModificarAsis().addActionListener(this);

        llenarCombo();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object boton = e.getSource();
        if (boton.equals(vistInicio.btnIngresar)) {
            usuarioEdit = vistInicio.validarCamposVacioUsu();
            if (vistInicio.isValidacion()) {
                vistMenu.setVisible(true);
                vistInicio.setVisible(false);
            }
        }
        //menu----------------------------------------------------------------
        if (boton.equals(vistMenu.jBttn_DatosUsuario)) {
            vistDatosUsu.llenar(usuarioEdit);
            vistDatosUsu.setVisible(true);
            vistMenu.setVisible(false);
        }
        if (boton.equals(vistMenu.jBttn_Registro)) {
            vistRegistAsis.getJbtn_ModificarAsis().setEnabled(false);            
            vistRegistAsis.setVisible(true);
            Date date = new Date();
            vistRegistAsis.getjDateChooser2().setDate(date);            
            vistMenu.setVisible(false);
        }
        
        if (boton.equals(vistMenu.jBttn_Mantenedor)) {                       
            vistMenu.setVisible(false);
            vistMenuMantenedor.setVisible(true);
        }             
       
        if (boton.equals(vistMenu.jBttn_Beneficiarios)) {
            llenarTablaBeneficiario();
            vistBeneficiarioLis.setVisible(true);
            vistMenu.setVisible(false);
        }
        
        if (boton.equals(vistMenuMantenedor.jBttn_Cursos)) {                       
            vistRegistCurso.setVisible(true);
            llenarTablaCurso();
            vistMenuMantenedor.setVisible(false);
        }           
        //Datos usuarios------------------------------------------------------
        if (boton.equals(vistDatosUsu.getjBtn_VerListaUsu())) {
            datosUsuTabla();
            vistListUsu.setVisible(true);
            vistDatosUsu.setVisible(false);
        }
        if (boton.equals(vistListUsu.getjButton_EditarDatos1())) {
            if (verifiSeleccion()) {
                vistEditarUsu.setVisible(true);
            }
        }
        if (boton.equals(vistEditarUsu.getjBtn_Modificar())) {
            valor = vistEditarUsu.editarUsu(usuario);

            datosUsuTabla();
            if (valor == true) {
                JOptionPane.showMessageDialog(null, "Los datos fueron modificados", "Sistema", JOptionPane.PLAIN_MESSAGE);
                vistEditarUsu.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Los datos no fueron modificados", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }

        if (boton.equals(vistListUsu.getjButton_AgregarUsu())) {
            vistNuevUsu.setVisible(true);
            //vistListUsu.setVisible(false);
        }
        if (boton.equals(vistNuevUsu.getJbtn_guardarUsu())) {
            vistListUsu.setVisible(true);
            crearUsuario();
            vistNuevUsu.setVisible(false);
        }

        //Registro de asistencia---------------------------------------------
        
         if (boton.equals(vistRegistAsis.getJbtn_GenerarReporteEnPdf())){
            reports.setVisible(true);
        }
        if (boton.equals(vistRegistAsis.getJbtn_guardar())) {
            RecorrerTabla();
            //debe ir il ingreso de la asistensia a la base de datos
            vistMenu.setVisible(true);
            vistRegistAsis.setVisible(false);
        }
         
         
        if (boton.equals(vistRegistAsis.getJbtn_editarCurso())) { // editar cursos disponibles
            //debe ir el metdodo para llenar la tabla

            llenarTablaCurso();
            vistRegistCurso.setVisible(true);
        }
        if (boton.equals(vistRegistCurso.getJbtn_Editar())) {

            if (verifiSeleccionCurso()) {
                vistEditarCurso.setVisible(true);
            }
            //presentar un mensaje que fueron guardados sus datos en la base
        }

        if (boton.equals(vistRegistCurso.Jbtn_agrCurso)) { // Brir ventana para agregar curso
            vistCrearCurso.setVisible(true);
        }
        if (boton.equals(vistCrearCurso.Jbtn_inscCurso)) { // Brir ventana para agregar curso
            //debe guardar el nuevo curso creado y debe presentar la nueva lista de cursos

            anadirCurso();
            llenarTablaCurso();
            vistCrearCurso.setVisible(false);
            vistRegistCurso.setVisible(true);
        }

        //beneficiarios---------------------------------------------
        if (boton.equals(vistBeneficiarioLis.getjBttn_editarBenef())) { // Brir ventana para agregar curso
            if (verifiSeleccionBenefi()) {
                vistEditarDatos.setVisible(true);
//                vistBeneficiarioLis.setVisible(false);
            }
        }
        if (boton.equals(vistEditarDatos.getJbtn_guardarEdit())) { // -----------------------------------------------------------------------------------------------
            if (vistEditarDatos.editarBenefi()){
                vistEditarDatos.setVisible(false);
                vistBeneficiarioLis.setVisible(true);
                llenarTablaBeneficiario();
                JOptionPane.showMessageDialog(null, "Los Datos del Beneficiario fueron editados con exito");
            }           
        }
        if (boton.equals(vistBeneficiarioLis.getjBttn_asignarCurso())) { // Brir ventana para agregar curso
            if (verifiSeleCur()) {
                vistCursoPer.setVisible(true);
                //vistBeneficiarioLis.setVisible(false);
                //vistCursoPer.llenarCursos();
            }
        }
        
        if (boton.equals(vistBeneficiarioLis.getJBTN_exportarPDF())) {
               vistBeneFiltro.setVisible(true);
        }  
         
        if (boton.equals(vistCursoPer.getjBttnBuscarCurso())) {
             int index = vistCursoPer.getjCmbNombre().getSelectedIndex();
                vistCursoPer.llenarCursos(index);
            
                
            
//            if (vistCursoPer.verifiCurso()) {
//                vistCursoPer.setVisible(false);
//                //vistBeneficiarioLis.setVisible(false);
//                JOptionPane.showMessageDialog(null, "El curso fue registrado");
//            }
        }   
        
         if (boton.equals(vistBeneFiltro.getjBtn_GenerarPdf())) {             
            try {              
                generarListaBeneficiario();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        
        if (boton.equals(vistCursoPer.getjBttnGuardarCurso())) {
            if (vistCursoPer.verifiCurso()) {
                vistCursoPer.setVisible(false);
                //vistBeneficiarioLis.setVisible(false);
                JOptionPane.showMessageDialog(null, "El curso fue registrado");
            }
        }           
        if (boton.equals(vistBeneficiarioLis.getjBttn_AgregarBenefi())) { // abrir ventana para agregar curso
            crearbene.setVisible(true);
            vistBeneficiarioLis.setVisible(false);
        }
        if (boton.equals(crearbene.getJbtn_datoEconomicos())) {
            //validar campos vacios
            if (crearbene.getJtf_Nombres().getText().isEmpty() || crearbene.getJtf_Apellidos().getText().isEmpty()
                    || crearbene.getJtf_Dir().getText().isEmpty() || crearbene.getJtf_Cedula().getText().isEmpty()
                    || crearbene.getJtf_Correo().getText().isEmpty() || crearbene.getJtf_edad().getText().isEmpty()
                    || crearbene.getJtf_benf_celular().getText().isEmpty()
                    || crearbene.getJtf_benf_convencional().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No puede dejar campos vacios");
            } else {
                vistInsDatSocioEco.setVisible(true);
                crearbene.setVisible(false);

            }
        }
        //Datos economicos-----------------------------------------------------------------------
        if (boton.equals(vistInsDatSocioEco.getJbtn_guardarDatosSoeco())) {
            vistIngMadre.setVisible(true);
            vistInsDatSocioEco.agregarDatosSocialesEco();
            vistInsDatSocioEco.setVisible(false);

        }
        //Datos padres------------------------------------------------------------------carg-----
        if (boton.equals(vistIngPadre.getJbtn_datosEscolares()) || boton.equals(vistIngMadre.getJbtn_datosEscolares())) {
            if ((vistIngMadre.getJtf_nom_ape().getText()).equals("") || vistIngMadre.getJtf_lugar_trab().getText().equals("")
                    || vistIngMadre.getJtf_Cargo().getText().equals("") || vistIngMadre.getJtf_Tut_telef().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe completar todos los campos de la Madre", "Sistema", JOptionPane.INFORMATION_MESSAGE);

            } else {
                if ((vistIngPadre.getJtf_nom_ape().getText()).equals("") || vistIngPadre.getJtf_lugar_trab().getText().equals("")
                        || vistIngPadre.getJtf_Cargo().getText().equals("") || vistIngPadre.getJtf_Tut_telef().getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe completar todos los campos del Padre", "Sistema", JOptionPane.INFORMATION_MESSAGE);

                } else {
                    guardarDatosPadres();
                    vistInsDatEscolar.setVisible(true);
                    vistIngPadre.setVisible(false);
                    vistIngPadre.setVisible(false);
                    limpiar();
                    llenarTablaBeneficiario();
//                    vistListPadres.setVisible(true);//ventana para ver la lista de padres----------
                }
            }
        }
        

        //ver luego---------------------------------------------------------------------------------
//        if (boton.equals(vistListPadres.getjButton_AgregarPadr())) {
//            vistListPadres.setVisible(false);
////                    crearPadres();
//        }
//        if (boton.equals(vistListPadres.getjButton_EditarDatos())) {/// vo llama a una ventana
//            vistListPadres.setVisible(false);
//            modificarPadres();
//        }
//        if (boton.equals(vistListPadres.getjButton_Consultar())) {
//            vistListPadres.Jtab_Lst_Padres.setVisible(false);
//
//        }

        //Datos escolares 
        if (boton.equals(vistInsDatEscolar.getJbtn_guardarDatosFinal())) {
            guardarDatosEscolares();
            vistInsDatEscolar.setVisible(false);
            crearBeneficiario();
            CrearFicha();
            llenarTablaBeneficiario();
            vistBeneficiarioLis.setVisible(true);
        }

        if (boton.equals(vistInsDatEscolar.getBtnVisualizarTabla())) {
            vistaListaDatoEscolar.setVisible(true);
            visualizarDatosEscolares();
        }

        if (boton.equals(vistaListaDatoEscolar.getBtnRegresar())) {
            vistaListaDatoEscolar.setVisible(false);
        }

        if (boton.equals(vistaListaDatoEscolar.getjBtn_EditarDatos())) {
            if (verifiSelccionEscolar()) {
                vistEscolar_Editar.setVisible(true);
            }
        }
        if (boton.equals(vistEscolar_Editar.getJbtn_modificarDtoEscol())) {
            valor = vistEscolar_Editar.editarEscolaridad(editarescolar);
            visualizarDatosEscolares();

            if (valor == true) {
                JOptionPane.showMessageDialog(null, "Los datos fueron modificados", "Sistema", JOptionPane.PLAIN_MESSAGE);
                vistEscolar_Editar.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Los datos no fueron modificados", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }

        // boton guardar modificacion de curso
        if (boton.equals(vistEditarCurso.getjBtn_ModificarCurso())) {
            valor = vistEditarCurso.editarCurso(curso);

            llenarTablaCurso();
            if (valor == true) {
                JOptionPane.showMessageDialog(null, "Los datos fueron modificados", "Sistema", JOptionPane.PLAIN_MESSAGE);
                vistEditarCurso.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Los datos no fueron modificados", "Error", JOptionPane.WARNING_MESSAGE);
            }
            vistRegistAsis.jCmbBMaterias.setModel (new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar" }));
            llenarCombo();

        }

        //boton aistencias
        if (boton.equals(vistRegistAsis.getJbtn_BuscarAsistencia())) {

            System.out.println("");
            try {
                refrescar();
            } catch (Exception ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        } if (boton.equals(vistRegistAsis.getJbtn_ModificarAsis())){
            
            ModificarAsistencia();
            vistMenu.setVisible(true);
            vistRegistAsis.setVisible(false);
            
            
        }
        
        // reports
         if (boton.equals(reports.getjButtonGenerarReportsss())) {
            System.out.println("Arrived");
            reporteDeAsistencias();

        }

//        //Asistensias de los cursos------------------------------------------------------    
//        if (boton.equals(vistAsisGeneral.getjBttnGuardarForm())) {
//            vistAsisGeneral.setVisible(false);
//            vistMenu.setVisible(true);
//        }
//        if (boton.equals(vistAsisGeneral.getjBttnCerrarForm())) {
//            vistAsisGeneral.setVisible(false);
//            vistMenu.setVisible(true);
//        }

    }
    
    private boolean verifiSeleccionBenefi() {
        boolean valor = false;
        int idEdit = vistBeneficiarioLis.Jtab_LstBeneficiario.getSelectedRow();
        if (idEdit >= 0) {
            vistEditarDatos.llenar(idEdit,  modeloBenefi );
            valor = true;
        } else {
            JOptionPane.showMessageDialog(null, "No seleccionó el beficiario para poder editar");
        }
        return valor;
    }
    private boolean verifiSeleCur() {
        boolean valor = false;
        int idEdit = vistBeneficiarioLis.Jtab_LstBeneficiario.getSelectedRow();
        if (idEdit >= 0) {
            vistCursoPer.llenarDatoPadres(idEdit,  modeloBenefi );
            valor = true;
        } else {
            JOptionPane.showMessageDialog(null, "No seleccionó el beficiario");
        }
        return valor;
    }

    //    Daoimple ren= new Daoimple();
    public void datosUsuTabla() {
        DaoUsuario daousu = new DaoUsuario();
        this.datos = daousu.consultar();
        modelo.setNumRows(0);
        for (Object[] daots : this.datos) {
            this.modelo.addRow(daots);
        }
        vistListUsu.Jtab_Lst_Usu.setModel(modelo);
    }

    public boolean validarEstado() {
        boolean estado = false;
        String validar = (String) vistNuevUsu.getjCmBestadoUsu().getSelectedItem();
        if (validar == "Activo") {
            estado = true;
        }
        System.out.println(" el estado es " + estado + " ------------------------------");/////validar estado del usuario

        return estado;
    }

    public void crearUsuario() {
        Usuario usu = new Usuario(vistNuevUsu.getJtf_NomUsu().getText(), vistNuevUsu.getjPsw_ContraUsu().getText(),
                (String) vistNuevUsu.getjCmBTipo().getSelectedItem(), validarEstado());
        System.out.println("la contraseña es " + vistNuevUsu.getjPsw_ContraUsu().getText());
        try {
            IUsuario datosUsu = new DaoUsuario();
            valor = datosUsu.insertar(usu);
            datosUsuTabla();
            limpiar();
            if (valor) {
                JOptionPane.showMessageDialog(null, "El usuario fue creado con exito", "Sistema", JOptionPane.PLAIN_MESSAGE);
                vistNuevUsu.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Los datos no fueron modificados", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Recuerde que el campo id es una clave foranea "
                    + "asi que solo se puede ingresar datos que pertenescan a esa tabla como US", "Error", JOptionPane.WARNING_MESSAGE);
            System.out.println("error REGISTRAR" + e.getMessage());
        }
    }

    public void cargaSocioEconomico(String forma_trabajo, String per_sustento, String Otros_ing, String gasto_mens) {
        CrearSocioEconomico(forma_trabajo, per_sustento, Otros_ing, gasto_mens);

    }

    public void CrearSocioEconomico(String forma_trabajo, String per_sustento, String Otros_ing, String gasto_mens) {
        Ins_DatoSocialesEco vistaSocialEco = new Ins_DatoSocialesEco();
        Reg_dataSocial modeDatoSocioEco = new Reg_dataSocial(per_sustento, forma_trabajo, Otros_ing, gasto_mens);
        try {
            ISocioEconomico daoSocioEco = new DaoSocioEconomico();
            daoSocioEco.insertar(modeDatoSocioEco);
            datosSociales = daoSocioEco.obtener(modeDatoSocioEco);
//            System.out.println("este---------------"+ datosSociales.getId_socioeconmico());
//            beneficiario.setId_socioec(datosSociales.getId_socioeconmico());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Recuerde que el campo id es una clave primaria "
                    + "asi que solo se puede ingresar datos que pertenescan a esa tabla ", "Error", JOptionPane.WARNING_MESSAGE);
            System.out.println("error REGISTRAR" + e.getMessage());
        }

    }

    public void CrearFicha() {
        try {
            IFicha ficha = new DaoFicha();
            ficha.insertar();
            //limpiarSocioEco();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Recuerde que el campo id es una clave primaria "
                    + "asi que solo se puede ingresar datos que pertenescan a esa tabla ", "Error", JOptionPane.WARNING_MESSAGE);
            System.out.println("error REGISTRAR" + e.getMessage());
        }
    }

    public void llenarTablaBeneficiario() {
        DaoBeneficiario daobenefi = new DaoBeneficiario();

        this.datos = daobenefi.consultar();
        modeloBenefi = new DefaultTableModel(COLUMBenefi, 0);

        modeloBenefi.setNumRows(0);
        for (Object[] daots : this.datos) {
            modeloBenefi.addRow(daots);
        }
        vistBeneficiarioLis.Jtab_LstBeneficiario.setModel(modeloBenefi);
        vistBeneficiarioLis.getjLbIngresarTexto().setText("Total de beneficiarios: ");
        vistBeneficiarioLis.getjLblIngresarNumBenefi1().setText(String.valueOf(modeloBenefi.getRowCount()));
    }

    public void limpiar() { //mover a la vista(mas estetico)
        vistNuevUsu.getJtf_NomUsu().setText("");
        vistNuevUsu.getjPsw_ContraUsu().setText("");

        vistIngPadre.getJtf_nom_ape().setText("");
        vistIngPadre.getJtf_lugar_trab().setText("");
        vistIngPadre.getJtf_Cargo().setText("");
        vistIngPadre.getJtf_Tut_telef().setText("");
        vistIngMadre.getJtf_nom_ape().setText("");
        vistIngMadre.getJtf_lugar_trab().setText("");
        vistIngMadre.getJtf_Cargo().setText("");
        vistIngMadre.getJtf_Tut_telef().setText("");

    }

    private boolean verifiSeleccion() {
        boolean valor = false;
        int idEdit = vistListUsu.Jtab_Lst_Usu.getSelectedRow();
        if (idEdit >= 0) {
            llenarUsuVentan(idEdit);
            valor = true;
        } else {
            JOptionPane.showMessageDialog(null, "No seleccionó el usuario a editar");
        }
        return valor;
    }

    private boolean verifiSeleccionCurso() {
        boolean valor = false;
        int idEdit = vistRegistCurso.Jtbl_Asignaturas.getSelectedRow();
        System.out.println(idEdit);
        if (idEdit >= 0) {
            llenarCursoVentan(idEdit);
            valor = true;
        } else {
            JOptionPane.showMessageDialog(null, "No seleccionó el curso a editar");
        }
        return valor;
    }

    private void llenarUsuVentan(int idEdit) {
        usuario = new Usuario();
        Integer id, tiponum, numEstad;
        String tipo, usu, contra;
        boolean estad = true;

        id = (Integer) modelo.getValueAt(idEdit, 0);
        usuario.setId(id);

        usu = (String) modelo.getValueAt(idEdit, 1);
        usuario.setNombre(usu);
        vistEditarUsu.getjTxtUsuario().setText(usu);

        contra = (String) modelo.getValueAt(idEdit, 2);
        usuario.setPassword(contra);
        vistEditarUsu.getjTxtContra().setText(contra);

        tipo = (String) modelo.getValueAt(idEdit, 3);
        usuario.setTipo(tipo);
        vistEditarUsu.getjCmbTipo().setSelectedItem(tipo);

        estad = (boolean) modelo.getValueAt(idEdit, 4);
        usuario.setEstado(estad);
        if (estad) {
            numEstad = 0;
        } else {
            numEstad = 1;
        }
        vistEditarUsu.getjCmbEstado().setSelectedIndex(numEstad);
    }

    private void llenarCursoVentan(int idEdit) {
        curso = new CursoEntity();
        Integer id, numEstad;
        String nombre;
        String dirigido;
        boolean estad = true;
        id = (Integer) vistRegistCurso.Jtbl_Asignaturas.getValueAt(idEdit, 0);
        curso.setId(id);

//        vistEditarCurso.getJlb_Id().setText(String.valueOf(id));

        nombre = (String) vistRegistCurso.Jtbl_Asignaturas.getValueAt(idEdit, 1);
        curso.setNombre(nombre);
        vistEditarCurso.getjTxtCurso().setText(nombre);

        estad = (boolean) vistRegistCurso.Jtbl_Asignaturas.getValueAt(idEdit, 2);
        curso.setEstado(estad);
        if (estad) {
            numEstad = 0;
        } else {
            numEstad = 1;
        }
        vistEditarCurso.getJcb_EstadoCurso().setSelectedIndex(numEstad);
        
        dirigido = (String) vistRegistCurso.Jtbl_Asignaturas.getValueAt(idEdit, 3);
        curso.setDirigido(dirigido);
        vistEditarCurso.getJcb_DirigidoCurso().setSelectedItem(dirigido);
    }


//    public void modificarPadres() {//------------- Ver------------------------------------------------------------------------------------------Revisar
//        Papa pa = new Papa(vistIngPadre.getJtf_nom_ape().getText(), (String) vistIngPadre.getJcb_Estado().getSelectedItem(), vistIngPadre.getJtf_lugar_trab().getText(), vistIngPadre.getJtf_Cargo().getText(), vistIngPadre.getJtf_Tut_telef().getText());
//
//        Mama ma = new Mama(vistIngMadre.getJtf_nom_ape().getText(), (String) vistIngMadre.getJcb_Estado().getSelectedItem(), vistIngMadre.getJtf_lugar_trab().getText(), vistIngMadre.getJtf_Cargo().getText(), vistIngMadre.getJtf_Tut_telef().getText());
//
//        IPapa datospa = new DaoPapa();
//        datospa.modificar(pa);
////            datosPaTabla();
//
//        IMama datosma = new DaoMama();
//        datosma.modificar(ma);
////            datosMaTabla();
//
//    }

    @Override
    public void focusGained(FocusEvent e) {
        Object boton = e.getSource();
        if (boton.equals(vistIngMadre.getJRB_padre())) {
            vistIngPadre.getJRB_padre().setSelected(true);
            vistIngMadre.setVisible(false);
            vistIngPadre.setVisible(true);
        }
        if (boton.equals(vistIngPadre.getJRB_madre())) {
            vistIngMadre.getJRB_madre().setSelected(true);
            vistIngPadre.setVisible(false);
            vistIngMadre.setVisible(true);
        }

        if (boton.equals(vistInsDatEscolar.getJRB_primaria())) {
            vistInsDatEscolar.llenarGrdPrima();
        }
        if (boton.equals(vistInsDatEscolar.getJRB_secundaria())) {
            vistInsDatEscolar.llenarGrdSecun();
        }
        if (boton.equals(vistEscolar_Editar.getJRB_primaria())) {
            vistEscolar_Editar.llenarGrdPrima();
        }
        if (boton.equals(vistEscolar_Editar.getJRB_secundaria())) {
            vistEscolar_Editar.llenarGrdSecun();
        }
        if (boton.equals(vistEditarDatos.getJRB_primaria())) {
            vistEditarDatos.llenarGrdPrima();
        }
        if (boton.equals(vistEditarDatos.getJRB_secundaria())) {
            vistEditarDatos.llenarGrdSecun();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        Object boton = e.getSource();
        if (boton.equals(vistIngMadre.getJRB_madre())) {
            llenarModeloMa();
        }
        if (boton.equals(vistIngPadre.getJRB_padre())) {
            llenarModeloPa();
        }
    }

    private void guardarDatosPadres() {//--------------------------------------------------------------------------------------------------------------------------------
        Mama nuevMama = new Mama();
        Papa nuevPapa = new Papa();
        DaoPapa daopapa = new DaoPapa();
        DaoMama daomama = new DaoMama();
        llenarModeloPa();
        llenarModeloMa();

            daomama.insertar(modeMa);
            nuevMama = daomama.obtener(modeMa);

            daopapa.insertar(modePa);
            nuevPapa = daopapa.obtener(modePa);
            modeMa = nuevMama;
            modePa = nuevPapa;
            guardarPadres();
    }

    private void llenarModeloMa() {
        modeMa.setNombre(vistIngMadre.getJtf_nom_ape().getText());
        modeMa.setEst_civ_ma((String) vistIngMadre.getJcb_Estado().getSelectedItem());
        modeMa.setLug_tra_ma(vistIngMadre.getJtf_lugar_trab().getText());
        modeMa.setCargo_ma(vistIngMadre.getJtf_Cargo().getText());
        modeMa.setTelefono(vistIngMadre.getJtf_Tut_telef().getText());

    }

    private void llenarModeloPa() {
        modePa.setNombre(vistIngPadre.getJtf_nom_ape().getText());
        modePa.setEst_civ_pa((String) vistIngPadre.getJcb_Estado().getSelectedItem());
        modePa.setLug_tra_pa(vistIngPadre.getJtf_lugar_trab().getText());
        modePa.setCargo_pa(vistIngPadre.getJtf_Cargo().getText());
        modePa.setTelefono(vistIngPadre.getJtf_Tut_telef().getText());
    }

    private void guardarPadres() {
        Padres nuvPadres = new Padres();
        nuvPadres.setId_mama(modeMa.getId_mama());
        nuvPadres.setId_papa(modePa.getId_papa());
        nuvPadres.setIng_econ(String.valueOf(vistInsDatSocioEco.getIngreso()));
        DaoPadres daoPadres = new DaoPadres();
        daoPadres.insertar(nuvPadres);
        modpadres = daoPadres.obtener(nuvPadres);

        JOptionPane.showMessageDialog(null, "Los datos de los padres fueron ingresados, id de padres es " + modpadres.getId_padres(), "Sistema", JOptionPane.INFORMATION_MESSAGE);
    }

//  
//    private void llenarDatosPadres() {
//        DaoMama daoma = new DaoMama();
//        DaoPapa daopa = new DaoPapa();
//        this.datosm = daoma.consultar();
//        this.datosp = daopa.consultar();
//        modeloPadres.setNumRows(0);
//        for (Object[] daots : this.datosm) {
//            this.modeloPadres.addRow(daots);
//        }
//        for (Object[] daots : this.datosp) {
//            this.modeloPadres.addRow(daots);
//        }
//        TableRowSorter<TableModel> ordenar = new TableRowSorter<TableModel>(modeloPadres);
//        vistListUsu.Jtab_Lst_Usu.setRowSorter(ordenar);
//        vistListPadres.getJtab_Lst_Padres().setModel(modeloPadres);
//    }

    private void guardarDatosEscolares() {
        String escolaridad;
        String nom_escu;
        String grado;
        String nom_Prof;
        String tel_Prof;
        String dire_Escu;
        DaoEscolaridad varDao = new DaoEscolaridad();
        Reg_Escolar obj_Escolar = new Reg_Escolar();
        if (vistInsDatEscolar.getJRB_primaria().isSelected()) {

            //        id_escuela=Integer.valueOf(vistInsDatEscolar.getEntradaIdEstudiante().getText());
            nom_escu = vistInsDatEscolar.getJtf_NombInst().getText();
            escolaridad = "Primaria";
            grado = (String) vistInsDatEscolar.getjCmBGrado().getSelectedItem();
            nom_Prof = vistInsDatEscolar.getJtf_NombreDocente().getText();
            tel_Prof = vistInsDatEscolar.getJtf_Cel().getText();
            dire_Escu = vistInsDatEscolar.getJtf_DireEscolar().getText();

            obj_Escolar.setBen_nomEsc(nom_escu);
            obj_Escolar.setBen_escolaridad(escolaridad);
            obj_Escolar.setBen_grado(grado);
            obj_Escolar.setBen_nomprof(nom_Prof);
            obj_Escolar.setBen_numprof(tel_Prof);
            obj_Escolar.setBen_dir(dire_Escu);

        } else if (vistInsDatEscolar.getJRB_secundaria().isSelected()) {

            nom_escu = vistInsDatEscolar.getJtf_NombInst().getText();
            escolaridad = "Secundaria";
            grado = (String) vistInsDatEscolar.getjCmBGrado().getSelectedItem();
            nom_Prof = vistInsDatEscolar.getJtf_NombreDocente().getText();
            tel_Prof = vistInsDatEscolar.getJtf_Cel().getText();
            dire_Escu = vistInsDatEscolar.getJtf_DireEscolar().getText();

            obj_Escolar.setBen_nomEsc(nom_escu);
            obj_Escolar.setBen_escolaridad(escolaridad);
            obj_Escolar.setBen_grado(grado);
            obj_Escolar.setBen_nomprof(nom_Prof);
            obj_Escolar.setBen_numprof(tel_Prof);
            obj_Escolar.setBen_dir(dire_Escu);

        }
        varDao.insertar(obj_Escolar); // Se encuentran guardado los datos escolares
        escolar = varDao.obtener(obj_Escolar); // se trae el id de escolar -----------------------------------Para adjuntarlo a beneficiario
        

    }

    public void visualizarDatosEscolares() {

        String COLUM[] = {"ID_Escuela", "Escolaridad", "Nombre_Escuela", "Grado", "Nombre_Profesor", "Telefono_Profesor", "Direccion_Escuela"};
        DaoEscolaridad varDao = new DaoEscolaridad();
        modelEscolaridad = new DefaultTableModel(COLUM, 0);
        ArrayList<Object[]> ojo = new ArrayList<>();
        // ListaDatosEscolar obj_Lista=new ListaDatosEscolar();
        modelEscolaridad.setNumRows(0);

        ojo = varDao.consultar();
        for (Object[] datitos : ojo) {

            modelEscolaridad.addRow(datitos);

        }

        vistaListaDatoEscolar.getTabla().setModel(modelEscolaridad);
        vistaListaDatoEscolar.getTotalRegistrados().setText("Total de registrados");
        vistaListaDatoEscolar.getRespuestaRegistrados().setText(String.valueOf(modelEscolaridad.getRowCount()));

    }

    private boolean verifiSelccionEscolar() {
        boolean val = false;
        int idEdit = vistaListaDatoEscolar.getTabla().getSelectedRow();
        if (idEdit >= 0) {
            llenarDatEscolarVentan(idEdit);

            val = true;
        } else {
            JOptionPane.showMessageDialog(null, "No seleccionó el usuario a editar");
        }
        return val;
    }

    private void llenarDatEscolarVentan(int idEdit) {
        editarescolar = new Reg_Escolar();
        Integer id;
        String escolaridad, nombEsc, grado, nomprof, direc, numprof;

        id = (Integer) modelEscolaridad.getValueAt(idEdit, 0);
        editarescolar.setId_escuela(id);

        escolaridad = (String) modelEscolaridad.getValueAt(idEdit, 1);
        if (escolaridad.equals("Primaria")) {
            vistEscolar_Editar.llenarGrdPrima();
            vistEscolar_Editar.getJRB_primaria().setSelected(true);

        } else if (escolaridad.equals("Secundaria")) {
            vistEscolar_Editar.llenarGrdSecun();
            vistEscolar_Editar.getJRB_secundaria().setSelected(true);
        }
        editarescolar.setBen_escolaridad(escolaridad);

        nombEsc = (String) modelEscolaridad.getValueAt(idEdit, 2);
        editarescolar.setBen_nomEsc(nombEsc);
        vistEscolar_Editar.getJtf_NombInst().setText(nombEsc);

        grado = (String) modelEscolaridad.getValueAt(idEdit, 3);
        editarescolar.setBen_grado(grado);
        vistEscolar_Editar.getjCmBGrado().setSelectedItem(grado);

        nomprof = (String) modelEscolaridad.getValueAt(idEdit, 4);
        editarescolar.setBen_nomprof(nomprof);
        vistEscolar_Editar.getJtf_NombreDocente().setText(nomprof);

        numprof = (String) modelEscolaridad.getValueAt(idEdit, 5);
        editarescolar.setBen_numprof(numprof);
        vistEscolar_Editar.getJtf_Cel().setText(numprof);

        direc = (String) modelEscolaridad.getValueAt(idEdit, 6);
        editarescolar.setBen_dir(direc);
        vistEscolar_Editar.getJtf_DireEscolar().setText(direc);

    }

    private void crearBeneficiario() {
        
        beneficiario.setNombre(crearbene.getJtf_Nombres().getText());
        beneficiario.setApellido(crearbene.getJtf_Apellidos().getText());
        beneficiario.setDireccion(crearbene.getJtf_Dir().getText());
        beneficiario.setCedula(crearbene.getJtf_Cedula().getText());
        beneficiario.setCorreo(crearbene.getJtf_Correo().getText());
        beneficiario.setReligion((String) crearbene.getJcb_Religion().getSelectedItem());
        beneficiario.setProm_sal(crearbene.prob_salud());
        beneficiario.setTelefono(crearbene.getJtf_benf_celular().getText());
        beneficiario.setEdad(Integer.parseInt(crearbene.getJtf_edad().getText()));
        beneficiario.setNum_conv(Integer.parseInt(crearbene.getJtf_benf_convencional().getText()));

        beneficiario.setId_socioec(escolar.getId_escuela());
       
        beneficiario.setId_padres(modpadres.getId_padres());
        beneficiario.setId_escu(escolar.getId_escuela());

        int año = crearbene.getJDC_fechanac().getCalendar().get(Calendar.YEAR);
        int mes = crearbene.getJDC_fechanac().getCalendar().get(Calendar.MARCH);
        int dia = crearbene.getJDC_fechanac().getCalendar().get(Calendar.DAY_OF_MONTH);

        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fecha = año + "-" + mes + "-" + dia;
            Date fechanaci = formato.parse(fecha);
            beneficiario.setFech_nac(fechanaci);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error en fecha: " + e, "Error", JOptionPane.INFORMATION_MESSAGE);
        }

        DaoBeneficiario daoBenefi = new DaoBeneficiario();
        daoBenefi.insertar(beneficiario);

    }

    public void anadirCurso() {

        boolean estado;
        estado = vistCrearCurso.Jcb_Estado.getSelectedItem().toString().equals("Activo");
        CursoEntity curso = new CursoEntity(vistCrearCurso.Jtf_Nombre.getText(),vistCrearCurso.Jcb_Dirigido.getSelectedItem().toString() ,estado);

        try {

            ICurso cursos = new DaoCurso();
            cursos.insertar(curso);

            vistCrearCurso.Jtf_Nombre.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Recuerde que el campo id es una clave foranea "
                    + "asi que solo se puede ingresar datos que pertenescan a esa tabla como US", "Error", JOptionPane.WARNING_MESSAGE);
            System.out.println("error REGISTRAR" + e.getMessage());
        }

    }

    public void llenarTablaCurso() {
        DaoCurso daocurso = new DaoCurso();

        this.datos = daocurso.consultar();
        String COLUM[] = {"ID", "Nombre", "Estado","Dirigido"};
        DefaultTableModel modelocurso = new DefaultTableModel(COLUM, 0);

        modelocurso.setNumRows(0);
        for (Object[] daots : this.datos) {
            modelocurso.addRow(daots);
        }
        vistRegistCurso.Jtbl_Asignaturas.setModel(modelocurso);

    }
    
    public void llenarCombo() {

        Connection conexion = null;
        PreparedStatement sta = null;
        Statement stm = null;
        ResultSet rs = null;
        boolean valor = false;

        String sql = "select id_curso,nom_cur from public.curso where estado_cur = true";

        try {

            this.conectar();
            conexion = this.getCon();
            sta = conexion.prepareStatement(sql);

            rs = sta.executeQuery();

            while (rs.next()) {
                vistRegistAsis.jCmbBMaterias.addItem(new CursoEntity(Integer.parseInt(rs.getString("id_curso")),
                        rs.getString("nom_cur")));
            }

            sta.close();
            conexion.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error en sql OBTENER curso combo:" + e.getMessage());
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object boton = e.getSource();
        if (boton.equals(vistNuevUsu.getjLblRetroceder())) {
            vistListUsu.setVisible(true);
            vistNuevUsu.setVisible(false);
        }
        if (boton.equals(vistDatosUsu.getjLblRetroceder())) {
            vistMenu.setVisible(true);
            vistDatosUsu.setVisible(false);
        }
        if (boton.equals(vistListUsu.getjLblRetroceder())) {
            vistEditarUsu.setVisible(false);
            vistListUsu.setVisible(false);
            vistDatosUsu.setVisible(true);
        }
        if (boton.equals(vistRegistCurso.getjLblRetroceder())) {
            vistMenuMantenedor.setVisible(true);
            vistRegistCurso.setVisible(false);
        }
        if (boton.equals(vistEditarUsu.getjLblRetroceder())) {
            vistEditarUsu.setVisible(false);
            vistListUsu.setVisible(true);
        }
        if (boton.equals(vistRegistAsis.getjLblRetroceder())) {
            vistMenu.setVisible(true);
            vistRegistAsis.setVisible(false);
        }
        if (boton.equals(vistBeneficiarioLis.getjLblRetroceder())) {
            vistMenu.setVisible(true);
            vistBeneficiarioLis.setVisible(false);
        }
        if (boton.equals(crearbene.getjLblRetroceder())) {
            vistBeneficiarioLis.setVisible(true);
            crearbene.setVisible(false);
        }
        if (boton.equals(vistEditarDatos.getjLblRetroceder())) {
            vistBeneficiarioLis.setVisible(true);
            vistEditarDatos.setVisible(false);
        }
        if (boton.equals(vistCrearCurso.getjLblRetroceder())) {
            vistMenuMantenedor.setVisible(true);
            vistCrearCurso.setVisible(false);
        }
        if (boton.equals(vistMenu.getjLblSalir())) {
            vistInicio.limpiar();
            vistInicio.setVisible(true);//--------------------------ver
            vistMenu.setVisible(false);
        }
        if (boton.equals(vistMenuMantenedor.getjLblSalir())) {
            vistMenu.setVisible(true);//--------------------------ver
            vistMenuMantenedor.setVisible(false);
        }
        if (boton.equals(vistCursoPer.getjLblRetroceder())) {
            vistBeneficiarioLis.setVisible(true);
            vistCursoPer.setVisible(false);
        }        
        if (boton.equals(vistEditarCurso.getjLblRetroceder())) {
            vistRegistCurso.setVisible(true);
            vistEditarCurso.setVisible(false);
        }
    }
    
    //registro de asistencias
    public void refrescar() throws Exception {
        
        if(vistRegistAsis.jDateChooser2.getDate()==null){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha");
        
        }

        //fecha extraida del calendario de la tabla
        int añoT = vistRegistAsis.jDateChooser2.getCalendar().get(Calendar.YEAR);
        int mesT = vistRegistAsis.jDateChooser2.getCalendar().get(Calendar.MARCH) + 1;
        int diaT = vistRegistAsis.jDateChooser2.getCalendar().get(Calendar.DAY_OF_MONTH);

        String fechaT = añoT + "-" + mesT + "-" + diaT;
        

        //fecha actual
        Calendar fecha = Calendar.getInstance();
        String año = String.valueOf(fecha.get(Calendar.YEAR));
        String mes = String.valueOf(fecha.get(Calendar.MONTH) + 1);
        String dia = String.valueOf(fecha.get(Calendar.DAY_OF_MONTH));
        String fechafinal = año + "-" + mes + "-" + dia;
        System.out.println( "fecha final= " + fechafinal + "fecha inicial= " + fechaT);

       

        DefaultTableModel modelo = new DefaultTableModel();

        String[] datos = new String[8];
        String strSelectBd;
        
        //
        
      
        
//-----    
        if (fechaT.equals(fechafinal)) {
           vistRegistAsis.getJbtn_ModificarAsis().setEnabled(false);
            vistRegistAsis.getJbtn_guardar().setEnabled(true);
           modelo.addColumn("Nombre");
            modelo.addColumn("Asistencias");

            vistRegistAsis.jTable2.setModel(modelo);

            try {
                Statement leer = this.conectar().createStatement();
                int selecion = vistRegistAsis.jCmbBMaterias.getItemAt(vistRegistAsis.jCmbBMaterias.getSelectedIndex()).getId();
              
                ResultSet resultado = leer.executeQuery("SELECT nombre_ma from mama INNER join padres ON padres.id_mama = mama.id_mama inner join asignacion_curso \n"
                        + "ON asignacion_curso.id_padres = padres.id_padres WHERE asignacion_curso.id_curso='" + selecion + "'\n"
                        + "\n"
                        + "union\n"
                        + "SELECT nombre_pa from papa INNER join padres ON padres.id_papa = papa.id_papa inner join asignacion_curso \n"
                       + "ON asignacion_curso.id_padres = padres.id_padres WHERE asignacion_curso.id_curso='" + selecion + "'");

                Object[] fila;
                while (resultado.next()) {
                    fila = new Object[5];
                  fila[0] = resultado.getString(1);

                    fila[1] = Boolean.FALSE;

                    modelo.addRow(fila);
                }
                vistRegistAsis.jTable2.setModel(modelo);
                addCheckBox(1, vistRegistAsis.jTable2);
                

            } catch (Exception e) {
                   JOptionPane.showMessageDialog(null, "Escoja un curso ", "Sistema", JOptionPane.PLAIN_MESSAGE);
            }


       } //--
        else {
            vistRegistAsis.getJbtn_ModificarAsis().setEnabled(true);
            vistRegistAsis.getJbtn_guardar().setEnabled(false);
             modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("Asistencias");

            vistRegistAsis.jTable2.setModel(modelo);
            
            try {
               Statement leer = this.conectar().createStatement();
               int selecion = vistRegistAsis.jCmbBMaterias.getItemAt(vistRegistAsis.jCmbBMaterias.getSelectedIndex()).getId();
               
                ResultSet resultado = leer.executeQuery("SELECT id_asis,estudiante, asistencia from asistencia where fech_asis='" + fechaT + "' and id_curso='" + selecion + "' ORDER by id_asis ASC");

                Object[] fila;
                while (resultado.next()) {
                    fila = new Object[3];
                    fila[0] = resultado.getInt(1);
                    fila[1] = resultado.getString(2);

                    strSelectBd = resultado.getString(3);

                 

                    if (strSelectBd.equals("t")) {
                        fila[2] = Boolean.TRUE;
                    } else {
                        fila[2] = Boolean.FALSE;
                    }

                    modelo.addRow(fila);
               }
                vistRegistAsis.jTable2.setModel(modelo);
                addCheckBox(2, vistRegistAsis.jTable2);

            } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Escoja un curso ", "Sistema", JOptionPane.PLAIN_MESSAGE);
            }
        }

    }

    public void addCheckBox(int column, JTable table) {
        TableColumn tc = table.getColumnModel().getColumn(column);
        tc.setCellEditor(table.getDefaultEditor(Boolean.class));
        tc.setCellRenderer(table.getDefaultRenderer(Boolean.class));

    }
    
    public void RecorrerTabla() {

        String fechaT, estudiante;
        int curso;
        boolean estado;

        int añoT = vistRegistAsis.jDateChooser2.getCalendar().get(Calendar.YEAR);
        int mesT = vistRegistAsis.jDateChooser2.getCalendar().get(Calendar.MARCH) + 1;
        int diaT = vistRegistAsis.jDateChooser2.getCalendar().get(Calendar.DAY_OF_MONTH);

        fechaT = añoT + "-" + mesT + "-" + diaT;

        curso = vistRegistAsis.jCmbBMaterias.getItemAt(vistRegistAsis.jCmbBMaterias.getSelectedIndex()).getId();
        

        for (int i = 0; i < vistRegistAsis.jTable2.getRowCount(); i++) {
            

            try {
               
                estudiante = (String) vistRegistAsis.jTable2.getValueAt(i, 0);
                estado = (boolean) vistRegistAsis.jTable2.getValueAt(i, 1);
                if (estado != true) {
                    estado = false;
                }

                AsistenciaEntity asist = new AsistenciaEntity(fechaT, estudiante, curso, estado);

                IAsistencia asistencias = new DaoAsistencia();
                asistencias.insertar(asist);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Recuerde que el campo id es una clave foranea "
                        + "asi que solo se puede ingresar datos que pertenescan a esa tabla como US", "Error", JOptionPane.WARNING_MESSAGE);
                System.out.println("error REGISTRAR" + e.getMessage());
            }

        }
    }
     public void ModificarAsistencia() {

        boolean estado;
        int idAsis;
       
        AsistenciaEntity asist = new AsistenciaEntity();
        
        
         for (int i = 0; i < vistRegistAsis.jTable2.getRowCount(); i++) {
           

            try {
                 idAsis = (int) vistRegistAsis.jTable2.getValueAt(i, 0);
                estado = (boolean) vistRegistAsis.jTable2.getValueAt(i, 2);
                if (estado != true) {
                    estado = false;
                }

                AsistenciaEntity asistencia = new AsistenciaEntity(idAsis, estado);

                IAsistencia asistencias = new DaoAsistencia();
                asistencias.modificar(asistencia);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Recuerde que el campo id es una clave foranea "
                        + "asi que solo se puede ingresar datos que pertenescan a esa tabla como US", "Error", JOptionPane.WARNING_MESSAGE);
                System.out.println("error REGISTRAR" + e.getMessage());
            }

        }
         JOptionPane.showMessageDialog(null, "Datos Actualizados con exito ----------------");


    }
    
    
    

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    
    private void generarListaBeneficiario() throws SQLException{   
        try {
            String usuario = "postgres";
        String contrasena = "admin";
    
        String base = "Buen_PastorB";

            conexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/"+base+"?"+ "user="+usuario+"&password="+contrasena);

            conexion.setAutoCommit(false);

            if (conexion != null) {
                System.out.println("Conexion lista");
            }
            
            String report = System.getProperty("user.dir") + "/src/reportes/ListadoBeneficiario.jrxml";
            
            JasperReport jasperReport = JasperCompileManager.compileReport(report);
            
            Map<String,Object> parametros = new HashMap<>();            
            
            String beneFiltro = vistBeneFiltro.Jcb_EstadoBeneficiario.getSelectedItem().toString();

            if(beneFiltro.equals("Todos")){
                beneFiltro = "%%";
            }

            parametros.put("getParamEstado", beneFiltro);
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros , conexion);

            JasperViewer.viewReport(jasperPrint,false);           
        } catch (JRException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }    
    
    
    public void generarReporteEnPdf(){
        
        String usuario = "postgres";
        String contrasena = "admin";
    
        String base = "Buen_PastorB";

        String rutaOrigen = System.getProperty("user.dir") + "/src/reportes/report1.jrxml";
        String rutaDestino = System.getProperty("user.dir") + "/src/reportes/report1.pdf";
        
         Connection conexion = null;

        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/"+base+"?"+ "user="+usuario+"&password="+contrasena);

            conexion.setAutoCommit(false);

            if (conexion != null) {
                System.out.println("Conexion lista");
            }

        } catch (Exception e) {
            System.err.println("Conexion no establecida ");

        }

        try {
            JasperReport jasperReport = JasperCompileManager.compileReport(rutaOrigen);

           

            Map parametros = new HashMap();
            
//            String item = vistRegistAsis.getjCmbBMaterias().getSelectedItem().toString();
//            Integer num = Integer.parseInt(item);
    
            String fecha;
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-M-d");
            
            fecha = simpleDateFormat.format(vistRegistAsis.getjDateChooser2().getDate());
            System.out.println(fecha);


            parametros.put("fech_asis", fecha);
            parametros.put("nom_cur", vistRegistAsis.getjCmbBMaterias().getSelectedItem().toString());
            System.out.println(parametros);
            Class.forName("org.postgresql.Driver");

            // Crear informe
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros , conexion);

            JasperExportManager.exportReportToPdf(jasperPrint);

            //JasperViewer.viewReport(jasperPrint);
            JasperViewer view = new JasperViewer(jasperPrint, false);
            
            view.setDefaultCloseOperation(view.DISPOSE_ON_CLOSE);
            
            view.setVisible(true);
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void generarReporteEnPdfConRangoDeFechas(){
        
       String usuario = "postgres";
        String contrasena = "admin";
    
        String base = "Buen_PastorB";
        String rutaOrigen = System.getProperty("user.dir") + "/src/reportes/report_general_asistencias.jrxml";
        String rutaDestino = System.getProperty("user.dir") + "/src/reportes/report1.pdf";
        
         Connection conexion2 = null;

        try {
            conexion2 = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/"+base+"?"+ "user="+usuario+"&password="+contrasena);

            conexion.setAutoCommit(false);

            if (conexion != null) {
               // System.out.println("Conexion lista");
            }

        } catch (SQLException e) {
            System.err.println("Conexion no establecida ");

        }

        try {
            JasperReport jasperReport2 = JasperCompileManager.compileReport(rutaOrigen);

           

            Map parametros2 = new HashMap();
            

            String fechaInicial;
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-M-d");
            
            
            String fechaFinal;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-M-d");
            
            fechaInicial = simpleDateFormat2.format(vistRegistAsis.getjDateChooser2().getDate());
            System.out.println(fechaInicial);

            fechaFinal = simpleDateFormat.format(vistRegistAsis.getjDateChooser3().getDate());
            System.out.println(fechaFinal);

            parametros2.put("fecha_inicial", fechaInicial);
            parametros2.put("fecha_final", fechaFinal);

            System.out.println(parametros2);
            Class.forName("org.postgresql.Driver");

            // Crear informe
            JasperPrint jasperPrint2 = JasperFillManager.fillReport(jasperReport2, parametros2 , conexion2);

            JasperExportManager.exportReportToPdf(jasperPrint2);

            //JasperViewer.viewReport(jasperPrint);
            JasperViewer view2 = new JasperViewer(jasperPrint2, false);
            
            view2.setDefaultCloseOperation(view2.DISPOSE_ON_CLOSE);
            
            view2.setVisible(true);
            

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void reporteDeAsistencias() {

        if (reports.getjRadioButtonReportsForCourses().isSelected()) {
            generarReporteEnPdf();
        } else if (reports.getjRadioButtonReportsGeneral().isSelected()) {

            generarReporteEnPdfConRangoDeFechas();

        } else {
            JOptionPane.showMessageDialog(null, "No se seleccionó ninguna opción");
        }
    }
}

--
-- PostgreSQL database dump
--

-- Dumped from database version 10.23
-- Dumped by pg_dump version 10.23

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- Name: sec_asig; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sec_asig
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1000
    CACHE 1;


ALTER TABLE public.sec_asig OWNER TO postgres;

--
-- Name: sec_curso; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sec_curso
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1000
    CACHE 1;


ALTER TABLE public.sec_curso OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: asignacion_curso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.asignacion_curso (
    id_asig integer DEFAULT nextval('public.sec_asig'::regclass) NOT NULL,
    id_padres integer NOT NULL,
    id_curso integer DEFAULT nextval('public.sec_curso'::regclass) NOT NULL
);


ALTER TABLE public.asignacion_curso OWNER TO postgres;

--
-- Name: sec_asis; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sec_asis
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1000
    CACHE 1;


ALTER TABLE public.sec_asis OWNER TO postgres;

--
-- Name: asistencia; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.asistencia (
    id_asis integer DEFAULT nextval('public.sec_asis'::regclass) NOT NULL,
    fech_asis date NOT NULL,
    asistencia boolean NOT NULL,
    id_curso integer NOT NULL
);


ALTER TABLE public.asistencia OWNER TO postgres;

--
-- Name: sec_benef; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sec_benef
    START WITH 72
    INCREMENT BY 1
    MINVALUE 72
    MAXVALUE 1000
    CACHE 1;


ALTER TABLE public.sec_benef OWNER TO postgres;

--
-- Name: sec_escu; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sec_escu
    START WITH 72
    INCREMENT BY 1
    MINVALUE 72
    MAXVALUE 1000
    CACHE 1;


ALTER TABLE public.sec_escu OWNER TO postgres;

--
-- Name: sec_soeco; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sec_soeco
    START WITH 72
    INCREMENT BY 1
    MINVALUE 72
    MAXVALUE 1000
    CACHE 1;


ALTER TABLE public.sec_soeco OWNER TO postgres;

--
-- Name: tipopersona; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tipopersona (
    cedula character varying(11) NOT NULL,
    fech_nac date NOT NULL,
    nombre character varying(100) NOT NULL,
    apellido character varying(100) NOT NULL,
    edad integer NOT NULL,
    telefono character varying(15) NOT NULL,
    direccion character varying(100) NOT NULL,
    correo character varying(100) NOT NULL,
    religion character varying(100) NOT NULL,
    id_tipopersona integer NOT NULL
);


ALTER TABLE public.tipopersona OWNER TO postgres;

--
-- Name: tipopersona_id_tipopersona_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.tipopersona_id_tipopersona_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipopersona_id_tipopersona_seq OWNER TO postgres;

--
-- Name: tipopersona_id_tipopersona_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.tipopersona_id_tipopersona_seq OWNED BY public.tipopersona.id_tipopersona;


--
-- Name: beneficiario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.beneficiario (
    id_bene integer DEFAULT nextval('public.sec_benef'::regclass) NOT NULL,
    prom_sal character varying(100) NOT NULL,
    id_escu integer DEFAULT nextval('public.sec_escu'::regclass) NOT NULL,
    id_socieco integer DEFAULT nextval('public.sec_soeco'::regclass) NOT NULL,
    id_tipopersona integer DEFAULT nextval('public.tipopersona_id_tipopersona_seq'::regclass),
    num_conv integer
);


ALTER TABLE public.beneficiario OWNER TO postgres;

--
-- Name: sec_cur; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sec_cur
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1000
    CACHE 1;


ALTER TABLE public.sec_cur OWNER TO postgres;

--
-- Name: curso; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.curso (
    id_curso integer DEFAULT nextval('public.sec_cur'::regclass) NOT NULL,
    nom_cur character varying(100) NOT NULL,
    estado_cur boolean NOT NULL,
    dirigido_cur character varying(100)
);


ALTER TABLE public.curso OWNER TO postgres;

--
-- Name: sec_escuela; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sec_escuela
    START WITH 72
    INCREMENT BY 1
    MINVALUE 72
    MAXVALUE 1000
    CACHE 1;


ALTER TABLE public.sec_escuela OWNER TO postgres;

--
-- Name: escuela; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.escuela (
    id_escu integer DEFAULT nextval('public.sec_escuela'::regclass) NOT NULL,
    escolaridad character varying(50) NOT NULL,
    nom_escu character varying(100) NOT NULL,
    grado character varying(50) NOT NULL,
    nom_prof character varying(100) NOT NULL,
    tele_prof character varying(11) NOT NULL,
    dir_escu character varying(100) NOT NULL
);


ALTER TABLE public.escuela OWNER TO postgres;

--
-- Name: sec_ben; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sec_ben
    START WITH 72
    INCREMENT BY 1
    MINVALUE 72
    MAXVALUE 1000
    CACHE 1;


ALTER TABLE public.sec_ben OWNER TO postgres;

--
-- Name: sec_fichaprin; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sec_fichaprin
    START WITH 72
    INCREMENT BY 1
    MINVALUE 72
    MAXVALUE 1000
    CACHE 1;


ALTER TABLE public.sec_fichaprin OWNER TO postgres;

--
-- Name: ficha_prin; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ficha_prin (
    id_fich integer DEFAULT nextval('public.sec_fichaprin'::regclass) NOT NULL,
    id_bene integer DEFAULT nextval('public.sec_ben'::regclass) NOT NULL,
    fech_ins date NOT NULL
);


ALTER TABLE public.ficha_prin OWNER TO postgres;

--
-- Name: sec_mama; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sec_mama
    START WITH 72
    INCREMENT BY 1
    MINVALUE 72
    MAXVALUE 1000
    CACHE 1;


ALTER TABLE public.sec_mama OWNER TO postgres;

--
-- Name: mama; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.mama (
    id_mama integer DEFAULT nextval('public.sec_mama'::regclass) NOT NULL,
    est_civ_ma character varying(50) NOT NULL,
    lug_tra_ma character varying(100) NOT NULL,
    cargo_ma character varying(100) NOT NULL,
    id_tipopersona integer DEFAULT nextval('public.tipopersona_id_tipopersona_seq'::regclass),
    tele_ma character varying(11),
    nombre_ma character varying(100)
);


ALTER TABLE public.mama OWNER TO postgres;

--
-- Name: sec_ma; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sec_ma
    START WITH 72
    INCREMENT BY 1
    MINVALUE 72
    MAXVALUE 1000
    CACHE 1;


ALTER TABLE public.sec_ma OWNER TO postgres;

--
-- Name: sec_pa; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sec_pa
    START WITH 72
    INCREMENT BY 1
    MINVALUE 72
    MAXVALUE 1000
    CACHE 1;


ALTER TABLE public.sec_pa OWNER TO postgres;

--
-- Name: sec_padres; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sec_padres
    START WITH 72
    INCREMENT BY 1
    MINVALUE 72
    MAXVALUE 1000
    CACHE 1;


ALTER TABLE public.sec_padres OWNER TO postgres;

--
-- Name: padres; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.padres (
    id_padres integer DEFAULT nextval('public.sec_padres'::regclass) NOT NULL,
    ing_econ character varying(100) NOT NULL,
    id_papa integer DEFAULT nextval('public.sec_pa'::regclass) NOT NULL,
    id_mama integer DEFAULT nextval('public.sec_ma'::regclass) NOT NULL
);


ALTER TABLE public.padres OWNER TO postgres;

--
-- Name: sec_papa; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sec_papa
    START WITH 72
    INCREMENT BY 1
    MINVALUE 72
    MAXVALUE 1000
    CACHE 1;


ALTER TABLE public.sec_papa OWNER TO postgres;

--
-- Name: papa; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.papa (
    id_papa integer DEFAULT nextval('public.sec_papa'::regclass) NOT NULL,
    est_civ_pa character varying(50) NOT NULL,
    lug_tra_pa character varying(100) NOT NULL,
    cargo_pa character varying(100) NOT NULL,
    id_tipopersona integer DEFAULT nextval('public.tipopersona_id_tipopersona_seq'::regclass),
    nombre_pa character varying(100),
    tele_pa character varying(11)
);


ALTER TABLE public.papa OWNER TO postgres;

--
-- Name: sec_pds; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sec_pds
    START WITH 72
    INCREMENT BY 1
    MINVALUE 72
    MAXVALUE 1000
    CACHE 1;


ALTER TABLE public.sec_pds OWNER TO postgres;

--
-- Name: sec_socieco; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sec_socieco
    START WITH 72
    INCREMENT BY 1
    MINVALUE 72
    MAXVALUE 1000
    CACHE 1;


ALTER TABLE public.sec_socieco OWNER TO postgres;

--
-- Name: sec_usuarios; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sec_usuarios
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 1000
    CACHE 1;


ALTER TABLE public.sec_usuarios OWNER TO postgres;

--
-- Name: socioeconomico; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.socioeconomico (
    id_socieco integer DEFAULT nextval('public.sec_socieco'::regclass) NOT NULL,
    per_sus_ho character varying(100) NOT NULL,
    form_tra character varying(50) NOT NULL,
    otros_ing character varying(10) NOT NULL,
    gast_men character varying(10) NOT NULL
);


ALTER TABLE public.socioeconomico OWNER TO postgres;

--
-- Name: usuarios; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuarios (
    id_user integer DEFAULT nextval('public.sec_usuarios'::regclass) NOT NULL,
    ur_name character varying(100) NOT NULL,
    ur_password character varying(100) NOT NULL,
    ur_type character varying(50) NOT NULL,
    estado boolean NOT NULL
);


ALTER TABLE public.usuarios OWNER TO postgres;

--
-- Name: tipopersona id_tipopersona; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipopersona ALTER COLUMN id_tipopersona SET DEFAULT nextval('public.tipopersona_id_tipopersona_seq'::regclass);


--
-- Data for Name: asignacion_curso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.asignacion_curso (id_asig, id_padres, id_curso) FROM stdin;
1	1	1
\.


--
-- Data for Name: asistencia; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.asistencia (id_asis, fech_asis, asistencia, id_curso) FROM stdin;
\.


--
-- Data for Name: beneficiario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.beneficiario (id_bene, prom_sal, id_escu, id_socieco, id_tipopersona, num_conv) FROM stdin;
1	Ninguno	1	1	\N	\N
2	Ninguno	2	2	\N	\N
3	Ninguno	3	3	\N	\N
4	Ninguno	4	4	\N	\N
5	Ninguno	5	5	\N	\N
6	Ninguno	6	6	\N	\N
7	Ninguno	7	7	\N	\N
8	Ninguno	8	8	\N	\N
9	Ninguno	9	9	\N	\N
10	Ninguno	10	10	\N	\N
11	Ninguno	11	11	\N	\N
12	Ninguno	12	12	\N	\N
13	Ninguno	13	13	\N	\N
14	Ninguno	14	14	\N	\N
15	Ninguno	15	15	\N	\N
16	Ninguno	16	16	\N	\N
17	Ninguno	17	17	\N	\N
18	Ninguno	18	18	\N	\N
19	Ninguno	19	19	\N	\N
20	Ninguno	20	20	\N	\N
21	Ninguno	21	21	\N	\N
22	Ninguno	22	22	\N	\N
23	Ninguno	23	23	\N	\N
24	Ninguno	23	23	\N	\N
25	Ninguno	25	25	\N	\N
26	Ninguno	26	26	\N	\N
27	Ninguno	27	27	\N	\N
28	Alergia Asma	28	28	\N	\N
29	Ninguno	29	29	\N	\N
30	Ninguno	30	30	\N	\N
31	Ninguno	31	31	\N	\N
32	Convulsiones Febriles	32	32	\N	\N
33	Ninguno	33	33	\N	\N
34	Ninguno	34	34	\N	\N
35	Ninguno	35	35	\N	\N
36	Ninguno	36	36	\N	\N
37	Ninguno	37	37	\N	\N
38	Ninguno	38	38	\N	\N
39	Deficiencia Cognitiva	39	39	\N	\N
40	Ninguno	40	40	\N	\N
41	Ninguno	41	41	\N	\N
42	Ninguno	42	42	\N	\N
43	Ninguno	43	43	\N	\N
44	Ninguno	44	44	\N	\N
45	Discapacidad Intelectual	45	45	\N	\N
46	Ninguno	46	46	\N	\N
47	Asma	47	47	\N	\N
48	Ninguno	48	48	\N	\N
49	Ninguno	49	49	\N	\N
50	Ninguno	50	50	\N	\N
51	Ninguno	51	51	\N	\N
52	Ninguno	52	52	\N	\N
53	Ninguno	53	53	\N	\N
54	Ninguno	54	54	\N	\N
55	Ninguno	55	55	\N	\N
56	Ninguno	56	56	\N	\N
57	Ninguno	57	57	\N	\N
58	Ninguno	58	58	\N	\N
59	Ninguno	59	59	\N	\N
60	Ninguno	60	60	\N	\N
61	Ninguno	61	61	\N	\N
62	Ninguno	62	62	\N	\N
63	Ninguno	63	63	\N	\N
64	Alergias	64	64	\N	\N
65	Ninguno	65	65	\N	\N
66	Ninguno	66	66	\N	\N
67	Ninguno	67	67	\N	\N
68	Ninguno	68	68	\N	\N
69	Ninguno	69	69	\N	\N
70	Ninguno	70	70	\N	\N
71	Ninguno	71	71	\N	\N
72	Ninguno	72	72	\N	\N
\.


--
-- Data for Name: curso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.curso (id_curso, nom_cur, estado_cur, dirigido_cur) FROM stdin;
2	navegadores	t	Madre
3	Buenas Practicas	t	Niño
1	Guitarra	t	Padre
4	Office	t	Niño
\.


--
-- Data for Name: escuela; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.escuela (id_escu, escolaridad, nom_escu, grado, nom_prof, tele_prof, dir_escu) FROM stdin;
1	Primaria	E. Particular Virgen del Rocio	6to Basica	Teresa de Arellano	0968032466	I. Trinitaria Coop. Nelson Mandela 2 Mz 762 5-B
2	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
3	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
4	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
5	Secundaria	Colegio Replica de Guayaquil	9no EGB	Actualizar	Actualizar	Actualizar
6	Primaria	Eloy Ortega Soto	Inicial 1	Actualizar	Actualizar	Actualizar
7	Primaria	Carlos Calderón Chico	3ro Básica	Actualizar	Actualizar	Isla Trinitaria
8	Primaria	SNH	Inicial 1	Gladys	Actualizar	En casa
9	Primaria	Pablo Palacio Suarez	6to Básica	Cyntia Rojas	Actualizar	I. Trinitaria Coop. Nelson Mandela 2 Mz 3 Solar 2
10	Primaria	Pablo Palacio Suarez	4to Básica	Diana Rojas	Actualizar	I. Trinitaria Coop. Nelson Mandela 2 Mz 3 Solar 2
11	Primaria	Carlos Calderón Chico	3ro Básica	Actualizar	Actualizar	Isla Trinitaria
12	Primaria	Roman Castro Carranza	5to Básica	Cecibel Calero	0978845580	Actualizar
13	Primaria	Roman Castro Carranza	3ro Básica	Actualizar	Actualizar	Actualizar
14	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
15	Primaria	Pablo Palacio Suarez	6to Básica	Vanessa Moralez	Actualizar	I. Trinitaria Coop. Nelson Mandela 2 Mz 3 Solar 2
16	Primaria	Pablo Palacio Suarez	1ro Básica	Jazmin Arellano	Actualizar	I. Trinitaria Coop. Nelson Mandela 2 Mz 3 Solar 2
17	Primaria	E. Fiscal Alejandrina Valdez	Inicial 1	Angela Ordoñez	0995254625	Portete y la 8va entre Venezuela
18	Secundaria	San Francisco Campo Coello	9no EGB	Soraya Pincón	Actualizar	Juan Tanca Marengo y la Atarazana
19	Secundaria	Otto Arosemena Gomez	8vo EGB	Cecilia Villon	Actualizar	29 y Galapagos
20	Primaria	Carlos Calderón Chico	6to Básica	Gina	0986853353	Isla Trinitaria
21	Primaria	Carlos Calderón Chico	1ro Básica	Actualizar	Actualizar	Isla Trinitaria
22	Primaria	Pablo Palacio Suarez	3ro Básica	Mayra Cano	098006860	I. Trinitaria Coop. Nelson Mandela 2 Mz 3 Solar 2
23	Primaria	Pablo Palacio Suarez	Inicial 2	Jazmin Arellano	Actualizar	I. Trinitaria Coop. Nelson Mandela 2 Mz 3 Solar 2
24	Primaria	SNH	Inicial 1	Amparo	Actualizar	En casa
28	Primaria	CEI Marcelo Mariano Suares Montes de Oca	Inicial 2	Ketty Jaramillo	0984792230	Isla Trinitaria
29	Primaria	Actualizar	Inicial 1	Cecilia Ruiz	Actualizar	Isla Trinitaria
31	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
40	Primaria	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
41	Primaria	Dr. Jorge Villares Moscoso	Inicial	Lcda. Hilda Vera	Actualizar	En la 39 y Garcia Goyena
44	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
45	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
49	Actualizar	col	Inicial	Vanessa	Actualizar	Visita en casa
50	Primaria	Escuela Roman Castro Caranza	Inicial 2	Tania Montaño	0979666008	Isla Trinitaria
53	Primaria	Jorge Villacreces Comot	Actualizar	Mercedes Cornejo	0979750851	Calle S Calle 19, Parroquia Febres Cordero
56	Primaria	Pablo Palacio Suarez	Inicial 2	Jazmin Arellano	0969205365	Nelson Mondela 2
64	Primaria	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
66	Primaria	SAFP	Inicial 1	Katty	0989662464	Migu. Alcivar Y carlos luis plaza Dañin
67	Primaria	Escuela Roman Castro Caranza	Inicial 2	Tania Montaño	0979666008	Isla Trinatria Coop.Angel Duarte Valverde Avenida 34-S
68	Secundaria	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
69	Secundaria	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
70	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
71	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
25	Primaria	Pablo Palacios Suarez	5to Básica	Cinthia Rojas	0982805085	Actualizar
26	Primaria	Pablo Palacios Suarez	1ro Básica	Cinthia Rojas	0982805085	Actualizar
30	Primaria	Escuela particular "Prof.Roman Castro Carranza	4to Básica	Samantha Alvarez	0967910931	Isla Trinitaria
32	Primaria	Pablo Palacios Suarez	1ro Básica	Jazmin	0969205365	Coop. Nelson Mandela 2 MZ 3 SL 2
33	Primaria	Pablo Palacios Suarez	4to Básica	Diana Rojas	Actualizar	Coop. Nelson Mandela 1
34	Primaria	Pablo Palacios Suarez	3er Básica	Mayra Cano	Actualizar	Coop. Nelson Mandela 1
35	Primaria	Pablo Palacios Suarez	2do Básica	Maggi Contreras	Actualizar	Coop. Nelson Mandela 1
36	Primaria	Escuela Fiscal "Ciudad de Esmeralda"	7mo Básica	Lcda. Maritza Pacheco	0986604565	Calle 29, diagonal al Wester Union
37	Primaria	Escuela Fiscal "Ciudad de Esmeralda"	5to Básica	Lcda. Rufina igueroa	997582091	Calle 29, diagonal al Wester Union
38	Primaria	Escuela Fiscal "Ciudad de Esmeralda"	2do Básica	Lcda. Bertha Palma	0980716945	Calle 29, diagonal al Wester Union
39	Primaria	Escuela DR: Leonidas Garcia Ortiz#127	5to Básica	Maria Escarlante	Actualizar	Coop: Naciones Unidas MZ 19 SL 12
42	Primaria	Manuela Saenz Aizpuru	6to Básica	Roxana Quimi	0994445896	Isla Trinitaria
43	Secundaria	Colegio guayaquil	10mo EGB	Gina Ruiz	Actualizar	Gomez Rendon1403 y Machala
46	Secundaria	Ati II Piyaguazo	8vo EGB	Ana Abad	0999109062	Guayaquil - Centro
47	Primaria	Bertha Valverde	4to Básica	Lic. Jacqueine Escalarde	Actualizar	Coop. 4 de Marzo
48	Primaria	Pablo Palacios Suarez	6to Básica	Actualizar	Actualizar	Actualizar
51	Primaria	Jorge Villacreces Comot	7mo Básica	Barbara Gonzales	0983907774	Calle S Calle 19, Parroquia Febres Cordero
52	Primaria	Jorge Villacreces Comot	3ro Básica	Miran Miranda	0985333205	Calle S Calle 19, Parroquia Febres Cordero
54	Secundaria	Armada Nacional	8vo EGB	Sheyla Trivino	0987227898	Ciudadela Moran Valverde Calle Vijia y Enero vijia
55	Primaria	Pablo Palacio Suarez	6to Básica	Vanessa Morales	0991660693	Nelson Mondela 2
57	Primaria	Roman Castro Carranza	5to Básica	Actualizar	Actualizar	Nelson Mondela 2
58	Primaria	Roman Castro Carranza	1ero Básica	Actualizar	Actualizar	Nelson Mondela 2
59	Primaria	Carlos Caldero Chico	6to Básica	Karen Adrian	0967753559	Isla Trinitaria Coop.4 de Marzo
60	Primaria	Carlos Calderon Chico	8vo EGB	Actualizar	Actualizar	Isla Trinitaria Coop.4 de Marzo
61	Primaria	Carlos Calderon Chico	4to Básica	Karen	Actualizar	Isla Trinitaria Coop.4 de Marzo
62	Primaria	Carlos Calderon Chico	2do Básica	Actualizar	Actualizar	Isla Trinitaria Coop.4 de Marzo
63	Primaria	Carlos Calderon Chico	6to Básica	Adriana Mareilo	Actualizar	Coop.4 de Marzo
65	Primaria	Eliana Espinel Del Milenium	2do Básica	Actualizar	Actualizar	Actualizar
27	Primaria	Justin Reyes	6to Básica	Sra Adriana	0967753559	Actualizar
72	Secundaria	Colegio Replica de Guayaquil	9no EGB	Tereza Garzon	0987456123	I. Trinitaria Coop. Nelson Mandela 2 Mz 5 Solar 14
\.


--
-- Data for Name: ficha_prin; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ficha_prin (id_fich, id_bene, fech_ins) FROM stdin;
1	1	2016-05-01
2	2	2016-05-01
3	3	2016-05-01
4	4	2016-05-01
5	5	2016-05-01
6	6	2016-05-01
7	7	2016-05-01
8	8	2016-05-01
9	9	2016-05-01
10	10	2016-05-01
11	11	2016-05-01
12	12	2016-05-01
13	13	2016-05-01
14	14	2016-05-01
15	15	2016-05-01
16	16	2016-05-01
17	17	2016-05-01
18	18	2016-05-01
19	19	2016-05-01
20	20	2016-05-01
21	21	2016-05-01
22	22	2016-05-01
23	23	2016-05-01
24	24	2016-05-01
25	25	2010-05-01
26	26	2010-05-01
27	27	2010-05-01
28	28	2010-05-01
29	29	2010-05-01
30	30	2010-05-01
31	31	2010-05-01
32	32	2010-05-01
33	33	2010-05-01
34	34	2010-05-01
35	35	2010-05-01
36	36	2010-05-01
37	37	2010-05-01
38	38	2010-05-01
39	39	2010-05-01
40	40	2010-05-01
41	41	2010-05-01
42	42	2010-05-01
43	43	2010-05-01
44	44	2010-05-01
45	45	2010-05-01
46	46	2010-05-01
47	47	2010-05-01
48	48	2010-05-01
49	49	2010-05-01
50	50	2010-05-01
51	51	2017-01-01
52	52	2017-05-01
53	53	2017-05-01
54	54	2017-05-01
55	55	2017-05-01
56	56	2017-05-01
57	57	2017-05-01
58	58	2017-05-01
59	59	2017-05-01
60	60	2017-05-01
61	61	2017-05-01
62	62	2017-05-01
63	63	2017-05-01
64	64	2017-05-01
65	65	2017-05-01
66	66	2017-05-01
67	67	2017-05-01
68	68	2017-05-01
69	69	2017-05-01
70	70	2017-05-01
71	71	2017-05-01
72	72	2016-05-01
\.


--
-- Data for Name: mama; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.mama (id_mama, est_civ_ma, lug_tra_ma, cargo_ma, id_tipopersona, tele_ma, nombre_ma) FROM stdin;
1	Soltera	Casa	Ama de Casa	\N	\N	\N
2	Soltera	Casa	Ama de Casa	\N	\N	\N
3	Soltera	Casa	Ama de Casa	\N	\N	\N
4	Soltera	Casa	Ama de Casa	\N	\N	\N
5	Casada	Casa	Cocinera	\N	\N	\N
6	Casada	Casa	Cocinera	\N	\N	\N
7	Casada	Casa	Ama de Casa	\N	\N	\N
8	Casada	Casa	Ama de Casa	\N	\N	\N
9	Divorciada	Calle	Vendedora Informal	\N	\N	\N
10	Divorciada	Calle	Vendedora Informal	\N	\N	\N
11	Soltera	Grafimpac	Engomadora	\N	\N	\N
12	Divorciada	Casa	Ama de Casa	\N	\N	\N
13	Divorciada	Casa	Ama de Casa	\N	\N	\N
14	Soltera	Casa	Ama de Casa	\N	\N	\N
15	Soltera	Casa	Ama de Casa	\N	\N	\N
16	Soltera	Casa	Ama de Casa	\N	\N	\N
17	Soltera	Calle	Comerciante	\N	\N	\N
18	Soltera	Local	Vendedora	\N	\N	\N
19	Soltera	Actualizar	Actualizar	\N	\N	\N
20	Soltera	Actualizar	Actualizar	\N	\N	\N
21	Soltera	Actualizar	Actualizar	\N	\N	\N
22	Union Libre	Casa	Ama de Casa	\N	\N	\N
23	Union Libre	Casa	Ama de Casa	\N	\N	\N
24	Union Libre	Casa	Ama de Casa	\N	\N	\N
25	Unido	Casa	Ama de Casa	\N	\N	\N
26	Unido	Casa	Ama de Casa	\N	\N	\N
27	Actualizar	Actualizar	Actualizar	\N	\N	\N
28	Soltera	No trabaja	Actualizar	\N	\N	\N
29	Soltera	No trabaja	actualizar	\N	\N	\N
30	Soltera	No trabaja	Actualizar	\N	\N	\N
32	Casada	No trabaja	Actualizar	\N	\N	\N
33	Soltera	No trabaja	Actualizar	\N	\N	\N
34	Soltera	No trabaja	Actualizar	\N	\N	\N
35	Soltera	No trabaja	Actualizar	\N	\N	\N
36	Soltera	Comerciante	Comerciante	\N	\N	\N
37	Soltera	Comerciante	Comerciante	\N	\N	\N
38	Soltera	Comerciante	Comerciante	\N	\N	\N
39	Casada	Actualizar	QD.	\N	\N	\N
40	Casada	Ama de casa	Actualizar	\N	\N	\N
41	Casada	Ama de casa	Actualizar	\N	\N	\N
43	Soltera	Ama de casa	Aseo	\N	\N	\N
44	Soltera	Ama de casa	Aseo	\N	\N	\N
47	Actualizar	Ama de casa	Actualizar	\N	\N	\N
48	Actualizar	Ama de casa / Vendedora	Actualizar	\N	\N	\N
49	Actualizar	Actualizar	Actualizar	\N	\N	\N
50	Soltera	Ama de casa	Actualizar	\N	\N	\N
51	Casada	Q D	Arregla casa 3 veces a la semana	\N	\N	\N
52	Casada	Q D	Arregla casa 3 veces a la semana	\N	\N	\N
53	Casada	Q D	Arregla casa 3 veces a la semana	\N	\N	\N
54	Casada	Q D	Arregla casa 3 veces a la semana	\N	\N	\N
55	Soltera	Vendedora informal	Actualizar	\N	\N	\N
56	Soltera	Vendedora informal	Actualizar	\N	\N	\N
57	Soltera	Decoradora de fiesta	Decoradora de fiesta	\N	\N	\N
58	Soltera	Decoradora de fiesta	Decoradora de fiesta	\N	\N	\N
59	Soltera	Ama de casa	Actualizar	\N	\N	\N
60	Soltera	Ama de casa	Actualizar	\N	\N	\N
61	Soltera	Ama de casa	Actualizar	\N	\N	\N
62	Soltera	Ama de casa	Actualizar	\N	\N	\N
63	Union libre	Ambulante	Comerciante	\N	\N	\N
64	Union libre	Ambulante	Comerciante	\N	\N	\N
65	Actualizar	Actualizar	Actualizar	\N	\N	\N
66	Soltera	Tienda	Ama de casa	\N	\N	\N
67	Soltera	Ama de casa	Actualizar	\N	\N	\N
68	Actualizar	Informal	Informal	\N	\N	\N
69	Actualizar	Informal	Informal	\N	\N	\N
70	Actualizar	Informal	Informal	\N	\N	\N
71	Actualizar	Informal	Informal	\N	\N	\N
31	Casada	Actualizar	Actualizar	\N	\N	\N
42	Soltera	Ama de casa	Aseo	\N	\N	\N
45	Soltera	Camal	Cocinera	\N	\N	\N
46	Soltera	Camal	Cocinera	\N	\N	\N
72	Soltera	Telconet	Programadora	\N	\N	\N
\.


--
-- Data for Name: padres; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.padres (id_padres, ing_econ, id_papa, id_mama) FROM stdin;
1	500	1	1
2	500	2	2
3	500	3	3
4	500	4	4
6	200	6	6
8	Actualizar	8	8
9	Actualizar	9	9
10	Actualizar	10	10
13	200	13	13
16	180	16	16
20	220	20	20
21	220	21	21
22	100	22	22
23	100	23	23
24	100	24	24
5	200	5	5
7	Actualizar	7	7
11	330	11	11
12	200	12	12
14	425	14	14
15	180	15	15
17	100	17	17
18	180	18	18
19	220	19	19
25	300	25	25
26	300	26	26
27	150	27	27
28	150	28	28
29	150	29	29
30	150	30	30
31	160	31	31
32	160	32	32
33	Actualizar	33	33
34	Actualizar	34	34
35	Actualizar	35	35
36	370	36	36
37	370	37	37
38	370	38	38
39	Actualizar	39	39
40	120	40	40
41	120	41	41
42	Actualizar	42	42
43	Actualizar	43	43
44	Actualizar	44	44
45	250	45	45
46	250	46	46
47	Actualizar	47	47
48	Actualizar	48	48
49	Actualizar	49	49
50	425	50	50
51	Actualizar	51	51
52	Actualizar	52	52
53	Actualizar	53	53
54	Actualizar	54	54
55	Actualizar	55	55
56	Actualizar	56	56
57	150	57	57
58	150	58	58
59	Actualizar	59	59
60	Actualizar	60	60
61	Actualizar	61	61
62	Actualizar	62	62
63	15	63	63
64	15	64	64
65	Actualizar	65	65
66	150	66	66
67	425	67	67
68	Actualizar	68	68
69	Actualizar	69	69
70	Actualizar	70	70
71	Actualizar	71	71
72	300	72	72
\.


--
-- Data for Name: papa; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.papa (id_papa, est_civ_pa, lug_tra_pa, cargo_pa, id_tipopersona, nombre_pa, tele_pa) FROM stdin;
1	Soltero	Calle	Chofer	\N	\N	\N
2	Soltero	Calle	Chofer	\N	\N	\N
3	Soltero	Calle	Chofer	\N	\N	\N
4	Soltero	Calle	Chofer	\N	\N	\N
5	Casado	Oficial del Albamileria	Oficial	\N	\N	\N
6	Casado	Oficial del Albamileria	Oficial	\N	\N	\N
7	Casado	Trabajo temporario	Actualizar	\N	\N	\N
8	Casado	Trabajo temporario	Actualizar	\N	\N	\N
9	Actualizar	Actualizar	Actualizar	\N	\N	\N
10	Actualizar	Actualizar	Actualizar	\N	\N	\N
11	Actualizar	Actualizar	Actualizar	\N	\N	\N
12	Actualizar	Actualizar	Actualizar	\N	\N	\N
13	Actualizar	Actualizar	Actualizar	\N	\N	\N
14	Actualizar	Actualizar	Actualizar	\N	\N	\N
15	Actualizar	Actualizar	Actualizar	\N	\N	\N
16	Actualizar	Actualizar	Actualizar	\N	\N	\N
17	Actualizar	Zapateria	Zapatero	\N	\N	\N
18	Actualizar	Actualizar	Actualizar	\N	\N	\N
19	Actualizar	Actualizar	Actualizar	\N	\N	\N
20	Actualizar	Actualizar	Actualizar	\N	\N	\N
21	Actualizar	Actualizar	Actualizar	\N	\N	\N
22	Unión Libre	Camaronera	Descabezador	\N	\N	\N
23	Unión Libre	Camaronera	Descabezador	\N	\N	\N
24	Unión Libre	Camaronera	Descabezador	\N	\N	\N
25	Unido	Actualizar	Vendedor ambulante	\N	\N	\N
26	Unido	Actualizar	Vendedor ambulante	\N	\N	\N
27	Soltero	Eventual	Actualizar	\N	\N	\N
28	Soltero	Ambulante	Reciclador	\N	\N	\N
29	Soltero	Ambulante	Actualizar	\N	\N	\N
30	Soltero	Ambulante	Reciclador	\N	\N	\N
31	Casado	Comerciante Ambulante	Actualizar	\N	\N	\N
32	Casado	Comerciante Ambulante	Actualizar	\N	\N	\N
33	Soltero	Duran	Soldador	\N	\N	\N
34	Soltero	Duran	Soldador	\N	\N	\N
35	Soltero	Duran	Soldador	\N	\N	\N
36	Soltero	Actualizar	Actualizar	\N	\N	\N
37	Soltero	Actualizar	Actualizar	\N	\N	\N
38	Soltero	Actualizar	Actualizar	\N	\N	\N
39	Actualizar	Actualizar	Actualizar	\N	\N	\N
40	Casado	Eventual	Actualizar	\N	\N	\N
41	Casado	Eventual	Actualizar	\N	\N	\N
42	Actualizar	Actualizar	Actualizar	\N	\N	\N
43	Actualizar	Actualizar	Actualizar	\N	\N	\N
44	Actualizar	Actualizar	Actualizar	\N	\N	\N
45	Actualizar	Actualizar	Actualizar	\N	\N	\N
46	Actualizar	Actualizar	Actualizar	\N	\N	\N
47	Actualizar	Actualizar	Actualizar	\N	\N	\N
48	Actualizar	Actualizar	Actualizar	\N	\N	\N
49	Actualizar	Actualizar	Actualizar	\N	\N	\N
50	Actualizar	Actualizar	Actualizar	\N	\N	\N
51	Actualizar	Actualizar	Actualizar	\N	\N	\N
52	Actualizar	Actualizar	Actualizar	\N	\N	\N
53	Actualizar	Actualizar	Actualizar	\N	\N	\N
54	Actualizar	Actualizar	Actualizar	\N	\N	\N
55	Actualizar	Comerciante	Actualizar	\N	\N	\N
56	Actualizar	Comerciante	Actualizar	\N	\N	\N
57	Actualizar	Actualizar	Actualizar	\N	\N	\N
58	Actualizar	Actualizar	Actualizar	\N	\N	\N
59	Soltero	Bahia	Vendedor ambulante	\N	\N	\N
60	Soltero	Bahia	Vendedor ambulante	\N	\N	\N
61	Soltero	Bahia	Vendedor ambulante	\N	\N	\N
62	Soltero	Bahia	Vendedor ambulante	\N	\N	\N
63	Union libre	Ambulante	Comerciante	\N	\N	\N
64	Union libre	Ambulante	Comerciante	\N	\N	\N
65	Actualizar	Actualizar	Actualizar	\N	\N	\N
66	Actualizar	Actualizar	Actualizar	\N	\N	\N
67	Actualizar	Actualizar	Actualizar	\N	\N	\N
68	Actualizar	Actualizar	Actualizar	\N	\N	\N
69	Actualizar	Actualizar	Actualizar	\N	\N	\N
70	Actualizar	Actualizar	Actualizar	\N	\N	\N
71	Actualizar	Actualizar	Actualizar	\N	\N	\N
72	Soltero	Telconet	Programadoro	\N	\N	\N
\.


--
-- Data for Name: socioeconomico; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.socioeconomico (id_socieco, per_sus_ho, form_tra, otros_ing, gast_men) FROM stdin;
1	Papa	Esporadico	Ninguno	500
2	Papa	Esporadico	Ninguno	500
3	Papa	Esporadico	Ninguno	500
4	Papa	Esporadico	Ninguno	500
5	Papa	Esporadico	Ninguno	300
6	Papa	Esporadico	Ninguno	300
7	Papa	Esporadico	Ninguno	100
8	Papa	Esporadico	Ninguno	100
9	Mama	Propio	Ninguno	100
10	Mama	Propio	Ninguno	100
11	Mama	Propio	Ninguno	Actualizar
12	Mama	Esporadico	Ninguno	200
13	Mama	Esporadico	Ninguno	200
14	Padrastro	Esporadico	Ninguno	400
15	Papa	Esporadico	Ninguno	180
16	Papa	Esporadico	Ninguno	180
17	Mama	Esporadico	Ninguno	100
18	Mama	Fijo	Ninguno	100
19	Mama	Propio	Ninguno	220
20	Mama	Propio	Ninguno	220
21	Mama	Propio	Ninguno	220
22	Papa	Esporadico	Ninguno	100
23	Papa	Esporadico	Ninguno	100
24	Papa	Esporadico	Ninguno	100
25	Hernesto Artidas	Esporadico	Ninguno	280
26	Hernesto Artidas	Esporadico	Ninguno	280
27	Padre	Esporadico	150	500
28	Padre	Esporadico	Ninguno	150
29	Abuelo	Esporadico	Ninguno	150
30	Padre	Esporadico	Ninguno	150
31	Darwin Moncada	Esporadico	Ninguno	130
32	Darwin Moncada	Esporadico	Ninguno	130
33	Orlin Garcia Jama	Esporadico	Ninguno	250
34	Orlin Garcia Jama	Esporadico	Ninguno	250
35	Orlin Garcia Jama	Esporadico	Ninguno	250
36	Abuelo Materno	Fijo	Actualizar	350
37	Abuelo Materno	Fijo	Actualizar	350
38	Abuelo Materno	Fijo	Actualizar	350
39	Hija	Esporadico	Ninguno	Actualizar
40	Alexis Artidas	Esporadico	Ninguno	Actualizar
41	Alexis Artidas	Esporadico	Ninguno	Actualizar
42	Mamá	Actualizar	Ninguno	Actualizar
43	Mamá	Actualizar	Ninguno	10
44	Mamá	Actualizar	Ninguno	Actualizar
45	Mariuxi Lopez Castillo	Propio	Ninguno	Actualizar
46	Mariuxi Lopez Castillo	Propio	Ninguno	Actualizar
47	Marjorie Mite Gordillo	Esporadico	Ninguno	Actualizar
48	Marjorie Mite Gordillo	Esporadico	Ninguno	200
49	Marjorie Mite Gordillo	Esporadico	Ninguno	Actualizar
50	Abuelita Miriam Reyes	Propio	Ninguno	300
51	Madre	Esporadico	Ninguno	Actualizar
52	Madre	Esporadico	Ninguno	Actualizar
53	Madre	Esporadico	Ninguno	Actualizar
54	Madre	Esporadico	Ninguno	Actualizar
55	Madre	Fijo	Actualizar	300
56	Madre	Fijo	Actualizar	300
57	Papa	Esporadico	150	200
58	Madre	Actualizar	150	200
59	Actualizar	Propio	Ninguno	4
60	Actualizar	Propio	Ninguno	4
61	Actualizar	Propio	Ninguno	4
62	Actualizar	Propio	Ninguno	4
63	Madre y Padre	Esporadico	15	20
64	Madre y Padre	Esporadico	15	20
65	Padrastro	Esporadico	Ninguno	250
66	Madre	Propio	150	150
67	Abuela y Madre	Propio	425	300
68	Madre	Propio	Ninguno	180
69	Madre	Propio	Ninguno	180
70	Madre	Actualizar	Ninguno	180
71	Madre	Actualizar	Ninguno	180
72	Papa	Fijo	Ninguno	100
73	Padre	Fijo	1	700
74	Madre	Fijo	1	700
75	Madre	Fijo	1	700
76	Padre	Fijo	0	700
77	Padre	Fijo	1	
78	Madre	Fijo	1	1
79	Madre	Fijo	1	1
80	Madre	Fijo	1	1
81	Madre	Fijo	1	1
\.


--
-- Data for Name: tipopersona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.tipopersona (cedula, fech_nac, nombre, apellido, edad, telefono, direccion, correo, religion, id_tipopersona) FROM stdin;
0953501277	2001-04-25	derian	zambrano	22	0987786332	vergeles	derian@gmail.com	catolica\n	1
\.


--
-- Data for Name: usuarios; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuarios (id_user, ur_name, ur_password, ur_type, estado) FROM stdin;
1	lgio	12345	admin	t
2	elbryan	567	admin	t
3	mady	246	admin	f
\.


--
-- Name: sec_asig; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec_asig', 1, true);


--
-- Name: sec_asis; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec_asis', 1, false);


--
-- Name: sec_ben; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec_ben', 72, true);


--
-- Name: sec_benef; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec_benef', 72, true);


--
-- Name: sec_cur; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec_cur', 4, true);


--
-- Name: sec_curso; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec_curso', 1, false);


--
-- Name: sec_escu; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec_escu', 72, true);


--
-- Name: sec_escuela; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec_escuela', 72, true);


--
-- Name: sec_fichaprin; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec_fichaprin', 72, true);


--
-- Name: sec_ma; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec_ma', 72, true);


--
-- Name: sec_mama; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec_mama', 72, true);


--
-- Name: sec_pa; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec_pa', 72, true);


--
-- Name: sec_padres; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec_padres', 72, true);


--
-- Name: sec_papa; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec_papa', 72, true);


--
-- Name: sec_pds; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec_pds', 72, true);


--
-- Name: sec_socieco; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec_socieco', 81, true);


--
-- Name: sec_soeco; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec_soeco', 72, true);


--
-- Name: sec_usuarios; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec_usuarios', 3, true);


--
-- Name: tipopersona_id_tipopersona_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tipopersona_id_tipopersona_seq', 1, false);


--
-- Name: asignacion_curso asignacion_curso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asignacion_curso
    ADD CONSTRAINT asignacion_curso_pkey PRIMARY KEY (id_asig);


--
-- Name: asistencia asistencia_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asistencia
    ADD CONSTRAINT asistencia_pkey PRIMARY KEY (id_asis);


--
-- Name: beneficiario beneficiario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.beneficiario
    ADD CONSTRAINT beneficiario_pkey PRIMARY KEY (id_bene);


--
-- Name: curso curso_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.curso
    ADD CONSTRAINT curso_pkey PRIMARY KEY (id_curso);


--
-- Name: escuela escuela_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.escuela
    ADD CONSTRAINT escuela_pkey PRIMARY KEY (id_escu);


--
-- Name: ficha_prin ficha_prin_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ficha_prin
    ADD CONSTRAINT ficha_prin_pkey PRIMARY KEY (id_fich);


--
-- Name: mama mama_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mama
    ADD CONSTRAINT mama_pkey PRIMARY KEY (id_mama);


--
-- Name: padres padres_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.padres
    ADD CONSTRAINT padres_pkey PRIMARY KEY (id_padres);


--
-- Name: papa papa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.papa
    ADD CONSTRAINT papa_pkey PRIMARY KEY (id_papa);


--
-- Name: socioeconomico socioeconomico_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.socioeconomico
    ADD CONSTRAINT socioeconomico_pkey PRIMARY KEY (id_socieco);


--
-- Name: tipopersona tipoPersona_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tipopersona
    ADD CONSTRAINT "tipoPersona_pkey" PRIMARY KEY (id_tipopersona);


--
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id_user);


--
-- Name: fki_id_tipoPersona; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "fki_id_tipoPersona" ON public.mama USING btree (id_tipopersona);


--
-- Name: fki_id_tipoPersona_fkey; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "fki_id_tipoPersona_fkey" ON public.papa USING btree (id_tipopersona);


--
-- Name: asignacion_curso fkasig; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asignacion_curso
    ADD CONSTRAINT fkasig FOREIGN KEY (id_padres) REFERENCES public.padres(id_padres);


--
-- Name: asistencia fkasis; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asistencia
    ADD CONSTRAINT fkasis FOREIGN KEY (id_curso) REFERENCES public.curso(id_curso);


--
-- Name: asignacion_curso fkcurso; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.asignacion_curso
    ADD CONSTRAINT fkcurso FOREIGN KEY (id_curso) REFERENCES public.curso(id_curso);


--
-- Name: beneficiario fkescuelas; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.beneficiario
    ADD CONSTRAINT fkescuelas FOREIGN KEY (id_escu) REFERENCES public.escuela(id_escu);


--
-- Name: ficha_prin fkfichas; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ficha_prin
    ADD CONSTRAINT fkfichas FOREIGN KEY (id_bene) REFERENCES public.beneficiario(id_bene);


--
-- Name: padres fkmadres; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.padres
    ADD CONSTRAINT fkmadres FOREIGN KEY (id_mama) REFERENCES public.mama(id_mama);


--
-- Name: padres fkpapas; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.padres
    ADD CONSTRAINT fkpapas FOREIGN KEY (id_papa) REFERENCES public.papa(id_papa);


--
-- Name: beneficiario fksocieconomicos; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.beneficiario
    ADD CONSTRAINT fksocieconomicos FOREIGN KEY (id_socieco) REFERENCES public.socioeconomico(id_socieco);


--
-- Name: papa id_tipoPersona_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.papa
    ADD CONSTRAINT "id_tipoPersona_fkey" FOREIGN KEY (id_tipopersona) REFERENCES public.tipopersona(id_tipopersona);


--
-- Name: beneficiario id_tipoPersona_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.beneficiario
    ADD CONSTRAINT "id_tipoPersona_fkey" FOREIGN KEY (id_tipopersona) REFERENCES public.tipopersona(id_tipopersona) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- Name: mama id_tipoPersona_pKey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.mama
    ADD CONSTRAINT "id_tipoPersona_pKey" FOREIGN KEY (id_tipopersona) REFERENCES public.tipopersona(id_tipopersona);


--
-- PostgreSQL database dump complete
--


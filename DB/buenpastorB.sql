--
-- PostgreSQL database dump
--

-- Dumped from database version 10.22
-- Dumped by pg_dump version 10.22

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
-- Name: beneficiario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.beneficiario (
    id_bene integer DEFAULT nextval('public.sec_benef'::regclass) NOT NULL,
    cedula character varying(11) NOT NULL,
    fech_nac date NOT NULL,
    nom_bene character varying(100) NOT NULL,
    ape_bene character varying(100) NOT NULL,
    edad_bene integer NOT NULL,
    direccion character varying(100) NOT NULL,
    correo character varying(100) NOT NULL,
    religion character varying(100) NOT NULL,
    prom_sal character varying(100) NOT NULL,
    tele_bene character varying(11) NOT NULL,
    id_padres integer DEFAULT nextval('public.sec_pds'::regclass) NOT NULL,
    id_escu integer DEFAULT nextval('public.sec_escu'::regclass) NOT NULL,
    id_socieco integer DEFAULT nextval('public.sec_soeco'::regclass) NOT NULL,
    num_conv integer NOT NULL
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
    estado_cur boolean NOT NULL
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
    nombre_ma character varying(100) NOT NULL,
    est_civ_ma character varying(50) NOT NULL,
    lug_tra_ma character varying(100) NOT NULL,
    cargo_ma character varying(100) NOT NULL,
    tele_ma character varying(11) NOT NULL
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
    nombre_pa character varying(100) NOT NULL,
    est_civ_pa character varying(50) NOT NULL,
    lug_tra_pa character varying(100) NOT NULL,
    cargo_pa character varying(100) NOT NULL,
    tele_pa character varying(11) NOT NULL
);


ALTER TABLE public.papa OWNER TO postgres;

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

COPY public.beneficiario (id_bene, cedula, fech_nac, nom_bene, ape_bene, edad_bene, direccion, correo, religion, prom_sal, tele_bene, id_padres, id_escu, id_socieco, num_conv) FROM stdin;
1	Actualizar	2005-01-01	Daniela Tomala	Mocha Tomala	13	I. Trinitaria Coop. Nelson Mandela 2 Mz 762 Solar 5-B	luismocha1570@hotmail.com	Catolica	Ninguno	0980627875	1	1	1	4
2	Actualizar	2005-01-02	Romina Naomi	Mocha Tomala	8	I. Trinitaria Coop. Nelson Mandela 2 Mz 762 Solar 5-B	luismocha1570@hotmail.com	Catolica	Ninguno	0980627875	2	2	2	4
3	Actualizar	2005-01-03	Luis Ernesto	Mocha Tomala	7	I. Trinitaria Coop. Nelson Mandela 2 Mz 762 Solar 5-B	luismocha1570@hotmail.com	Catolica	Ninguno	0980627875	3	3	3	4
4	Actualizar	2005-01-04	Maria Jose	Mocha Tomala	14	I. Trinitaria Coop. Nelson Mandela 2 Mz 762 Solar 5-B	luismocha1570@hotmail.com	Catolica	Ninguno	0980627875	4	4	4	4
5	Actualizar	2005-01-05	Nahomi Gardenia	Salavarria Bajaña	15	I. Trinitaria Coop. Nelson Mandela 2 Mz 5 Solar 14	Actualizar	Catolica	Ninguno	0967897781	5	5	5	4
6	Actualizar	2005-01-06	Mathias Emir	Salavarria Bajaña	5	I. Trinitaria Coop. Nelson Mandela 2 Mz 5 Solar 14	Actualizar	Catolica	Ninguno	0967897781	6	6	6	4
7	Actualizar	2005-01-07	Abel Jeremias	Espinoza Camacho	9	I. Trinitaria Coop. Angel Duarte Mz 424 Solar 10	Actualizar	Cristiana	Ninguno	0991989009	7	7	7	4
8	Actualizar	2005-01-08	Angelina Isabella	Espinoza Camacho	4	I. Trinitaria Coop. Angel Duarte Mz 424 Solar 10	Actualizar	Cristiana	Ninguno	0991989009	8	8	8	4
9	Actualizar	2005-01-09	Juan Sebastian	Burbano Navarro	11	I. Trinitaria Coop. Nelson Mandela 2 Mz 800 Solar 26	Actualizar	Catolica	Ninguno	0969920707	9	9	9	3
10	Actualizar	2005-01-10	Dylan Jeremías	Recalde Burbano	9	I. Trinitaria Coop. Nelson Mandela 2 Mz 800 Solar 26	Actualizar	Catolica	Ninguno	0969920707	10	10	10	3
11	Actualizar	2005-01-11	Alexander Luis	Murillo Sira	10	I. Trinitaria Coop. Nelson Mandela 2 Mz 722 Solar 15	Actualizar	Catolica	Ninguno	2602180	11	11	11	6
12	Actualizar	2005-01-12	Ryan Gabriel	Villegas Arellano	11	I. Trinitaria Coop. Brisas del Salado Mz 693 Solar 1	Actualizar	Actualizar	Ninguno	0979742776	12	12	12	3
13	Actualizar	2005-01-13	Adamaris Abigail	Villegas Arellano	10	I. Trinitaria Coop. Brisas del Salado Mz 693 Solar 1	Actualizar	Actualizar	Ninguno	0979742776	13	13	13	3
14	Actualizar	2005-01-14	Jhonny Caleb	Moreno Rivas	5	I. Trinitaria Coop. Angel Duarte Mz 423 Solar 1	genesismoreno22@hotmail.com	Actualizar	Ninguno	0980491529	14	14	14	7
15	Actualizar	2005-01-15	Joselyn Andrea	Tomala Reyes	12	I. Trinitaria Coop. Nelson Mandela 2 Mz 722 Solar 22	Actualizar	Actualizar	Ninguno	0981968233	15	15	15	3
16	Actualizar	2005-01-16	Jaime Isaac	Tomala Reyes	6	I. Trinitaria Coop. Nelson Mandela 2 Mz 722 Solar 22	Actualizar	Actualizar	Ninguno	0981968233	16	16	16	3
17	Actualizar	2005-01-17	Julieth Aina	Aroca Peso	7	I. Trinitaria Coop. Brisas del Salado Mz 24 Solar 10	pesolisbeth@gmail.com	Actualizar	Ninguno	0969493998	17	17	17	6
18	Actualizar	2005-01-18	Maria Clementina	Antepara Gonzalez	16	I. Trinitaria Coop. Nelson Mandela 2 Mz 722 Solar 21	lg2163877@gmail.com	Catolica	Ninguno	0969683022	18	18	18	4
19	Actualizar	2005-01-19	Bertha Elizabeth	Casalombo Vasquez	13	I. Trinitaria Coop. Nelson Mandela 2	Actualizar	Catolica	Ninguno	0939534160	19	19	19	4
20	Actualizar	2005-01-20	Jacob Damian	Casalombo Vasquez	11	I. Trinitaria Coop. Nelson Mandela 2	Actualizar	Catolica	Ninguno	0939534160	20	20	20	4
21	Actualizar	2005-01-21	Dunnia Daniela	Casalombo Vasquez	6	I. Trinitaria Coop. Nelson Mandela 2	Actualizar	Catolica	Ninguno	0939534160	21	21	21	4
22	Actualizar	2005-01-22	Ashley Tamara	Lusardo Rodriguez	11	I. Trinitaria Coop. Nelson Mandela 2 Mz 798 Solar 2	Actualizar	Catolica	Ninguno	0995191285	22	22	22	5
23	Actualizar	2005-01-23	Leslye Maite	Lusardo Rodriguez	6	I. Trinitaria Coop. Nelson Mandela 2 Mz 798 Solar 2	Actualizar	Catolica	Ninguno	0995191285	23	23	23	5
24	Actualizar	2005-01-23	Elyan Emiliano	Lusardo Rodriguez	4	I. Trinitaria Coop. Nelson Mandela 2 Mz 798 Solar 2	Actualizar	Catolica	Ninguno	0995191285	23	23	23	5
25	Actualizar	2004-01-01	Ashley Larissa	Artidas Chavez	11	Coop. Nelson Mandela Mz: 722 SL.20	Actualizar	Evangelica	Ninguno	0982822771	25	25	25	5
26	Actualizar	2004-01-02	Samara Nahomy	Artidas Chavez	7	Coop. Nelson Mandela Mz: 722 SL.20	Actualizar	Evangelica	Ninguno	0982822771	26	26	26	5
27	Actualizar	2004-01-03	Justin Gabriel	Reyes Miranda	12	Coop. Nelson Mandela MZ:800 SL:31	Actualizar	Catolica	Ninguno	0985611995	27	27	27	3
28	Actualizar	2004-01-04	Jayden Elian	Asnalema Monroy	6	Coop. Brisas del salado MZ 687 SL 8	narcisamonroy@hotmail.com	Catolica	Alergia Asma	0991633599	28	28	28	5
29	Actualizar	2004-01-05	Kenay	Ruiz Asnalema	5	Coop. Brisas del salado MZ 687 SL 8	narcisamonroy@hotmail.com	Catolica	Ninguno	0991633599	29	29	29	6
30	Actualizar	2004-01-06	Miguel Angel	Asnalema Monroy	11	Coop. Brisas del salado MZ 687 SL 8	narcisamonroy@hotmail.com	Catolica	Ninguno	0991633599	30	30	30	5
31	Actualizar	2004-01-07	Aysel Marina	Herrera Moncada	3	Coop. Nelson Mandela 2 MZ 3 SL 3	sheyla.28042017@hotmail.com	SUD	Ninguno	0979821304	31	31	31	3
32	Actualizar	2004-01-08	Ainoha Darling	Moncada Cantos	6	Coop. Nelson Mandela 2 MZ 3 SL 3	sheyla.28042017@hotmail.com	SUD	Convulsiones Febriles	0979821304	32	32	32	3
33	Actualizar	2004-01-09	Iker Gerard	Garcia Recalde	9	Coop. Nelson Mandela 2	k.ritodayrena@gmail.com	Actualizar	Ninguno	0959420923	33	33	33	5
34	Actualizar	2004-01-10	Thiago Ferney	Garcia Recalde	8	Coop. Nelson Mandela 2	k.ritodayrena@gmail.comm	Actualizar	Ninguno	0959420923	34	34	34	5
35	Actualizar	2004-01-11	Yandri Ibrahim	Garcia Recalde	7	Coop. Nelson Mandela 2	k.ritodayrena@gmail.comm	Actualizar	Ninguno	0959420923	35	35	35	5
36	Actualizar	2004-01-12	Elkyn Samyr	Moreira Pin	14	Coop. Nelson Mandela 2 MZ 4 SL 19	Actualizar	Catolica	Ninguno	0989575809	36	36	36	5
37	Actualizar	2004-01-13	Dennys Joel	Tumbaco Pin	6	Coop. Nelson Mandela 2 MZ 4 SL 19	Actualizar	Catolica	Ninguno	0989575809	37	37	37	5
38	Actualizar	2004-01-14	Adriel Aquiles	Arevalo Pin	7	Coop. Nelson Mandela 2 MZ 4 SL 19	Actualizar	Catolica	Ninguno	0989575809	38	38	38	5
39	Actualizar	2004-01-15	Alan Josue	Bustamante Montero	10	Coop. Brisas del salado MZ 11 SL 3	conocimiento146@gmail.com	Catolica	Deficiencia Cognitiva	2604006	39	39	39	2
40	Actualizar	2004-01-16	Giacina de Jesus	Artidas Criollo	3	Coop. Nelson Mandela 2	ycriogomez@hotmail.com	Catolica	Ninguno	0986784163	40	40	40	3
41	Actualizar	2004-01-17	Maria Angel Scarlet	Artidas Criollo	5	Coop. Nelson Mandela 2	ycriogomez@hotmail.com	Catolica	Ninguno	0986784163	41	41	41	3
42	Actualizar	2004-01-18	Julian Zacarias	Zamora Valencia	13	Angel Duarte MZ413 SL5	janethzu45@gmail.com	Catolica	Ninguno	0967648431	42	42	42	5
43	Actualizar	2004-01-19	Minerva del Carmen	Sevillano Zamora	16	Angel Duarte MZ413 SL5	janethzu45@gmail.com	Catolica	Ninguno	0967942977	43	43	43	5
44	Actualizar	2004-01-20	Jesus Guillermo	Zamora Valencia	6	Angel Duarte MZ413 SL5	janethzu45@gmail.com	Catolica	Ninguno	0967942977	44	44	44	5
45	Actualizar	2004-01-21	Jordan Lenin	Villacis Lopez	16	Coop. Brisas del salado	mariuxilopezcastillo@gmail.com	Actualizar	Discapacidad Intelectual	0958947904	45	45	45	4
46	Actualizar	2004-01-22	Pablo Andres	Villacis Lopez	14	Coop. Brisas del salado	mariuxilopezcastillo@gmail.com	Actualizar	Ninguno	0958947904	46	46	46	4
47	Actualizar	2004-01-23	Leonel Raphael	Alvarado Mite	11	Angel Duarte ME SL10 isla trinitaria	Actualizar	Catolica	Asma	0986085808	47	47	47	7
48	Actualizar	2004-01-24	Ivanna Mayte	Vargas Mite	13	isla trinitaria Angel Duarte ME SL10	Actualizar	Catolica	Ninguno	0986085808	48	48	48	7
49	Actualizar	2004-01-25	Zaid Alexis	Cool Mite	5	isla trinitaria Angel Duarte ME SL10	Actualizar	Catolica	Ninguno	Actualizar	49	49	49	7
50	Actualizar	2004-01-26	Paulina Ayleen 	Garcia Escalante	5	Isla Trinitaria Coop. Brisas del salado MZ684 SL 2	viviana.escalane14@hotmail.com	Actualizar	Ninguno	0968217085	50	50	50	3
51	Actualizar	2006-01-01	Naomi Scarlet	Reyes Peña	0	Coop. Brisas del soldado Mz 21 Sl 5	Ortizpeñamercedes@gmail.com	Catolica	Ninguno	0991164380	51	51	51	5
52	Actualizar	2006-01-02	Randy Frank	Reyes Peña	10	Coop. Brisas del soldado Mz 21 Sl 5	Ortizpeñamercedes@gmail.com	Catolica	Ninguno	0991164380	52	52	52	5
53	Actualizar	2006-01-03	Mia Paullete	Reyes Peña	12	Coop. Brisas del soldado Mz 21 Sl 5	Ortizpeñamercedes@gmail.com	Catolica	Ninguno	0991164380	53	53	53	5
54	Actualizar	2006-01-04	Italo Sisifredo	Reyes Peña	0	Coop. Brisas del soldado Mz 21 Sl 5	Ortizpeñamercedes@gmail.com	Catolica	Ninguno	0991164380	54	54	54	5
55	Actualizar	2006-01-05	Ashly Maria	Garcia Recalde 	11	Coop.Neson Mandela Mz800 Sl 26	Kellyrecalde_95@hotmail.com	Actualizar	Ninguno	0980627875	55	55	55	0
56	Actualizar	2006-01-06	Melanie Arianne	Garcia Recalde 	5	Coop.Neson Mandela Mz800 Sl 26	Kellyrecalde_95@hotmail.com	Actualizar	Ninguno	0980627875	56	56	56	0
57	Actualizar	2006-01-07	Alan Santiago	Rodriguez Martinez	11	Coop.Angel Duarte Mz 1 Sl 8	Actualizar	Catolica	Ninguno	0997054362	57	57	57	0
58	Actualizar	2006-01-08	Allisha Arlette	Molina Rodriguez	6	Coop.Angel Duarte Mz 1 Sl 8	Actualizar	Actualizar	Ninguno	0997054362	58	58	58	0
59	Actualizar	2006-01-09	Klever Abel	Moreira  Mata	12	Isla Trinitaria Coop.Angel Duarte Mz425 Sl4	Actualizar	Actualizar	Ninguno	0988237767	59	59	59	4
60	Actualizar	2006-01-10	Adam Jesus	Moreira  Mata	15	Isla Trinitaria Coop.Angel Duarte Mz425 Sl4	Actualizar	Actualizar	Ninguno	09988237767	60	60	60	4
61	Actualizar	2006-01-11	Arturo Marcelo	Moreira  Mata	10	Isla Trinitaria Coop.Angel Duarte Mz425 Sl4	Actualizar	Actualizar	Ninguno	0988237767	61	61	61	4
62	Actualizar	2006-01-12	Maykel Sebastian	Moreira  Mata	9	Isla Trinitaria Coop.Angel Duarte Mz425 Sl4	Actualizar	Actualizar	Ninguno	0988237767	62	62	62	4
63	Actualizar	2006-01-13	Oscar Antonio	Sandoval Tejada 	13	Nelson Mandela II Mz25 Sl10	Actualizar	Catolica	Ninguno	42017937	63	63	63	3
64	Actualizar	2006-01-14	Sebastian Joao	Sandoval Tejada 	5	Nelson Mandela II Mz25 Sl10	Actualizar	Catolica	Alergias	42017937	64	64	64	3
65	Actualizar	2006-01-15	Brithany Maria	Chalco Caicedo	8	Coop.Neslon Mandela II Mz722 Sl21	Actualizar	Catolica	Ninguno	0988279558	65	65	65	0
66	Actualizar	2006-01-16	Maidel Fiorela 	Cevallos Reyes	5	Coop.Nelson Mandela II Mz19 Sl7	eli.22.1993@gmail.com	Catolica	Ninguno	0961354135	66	66	66	0
67	Actualizar	2006-01-17	Paulina Ayleen	Garcia Escalante	5	Isla Trinitaria Coop.Brisas Del Salado Mz684	Vivian_escalante14@hotmail.com	Actualizar	Ninguno	0938217085	67	67	67	2
68	Actualizar	2006-01-18	Danna Esquivel	Veloz Aguilar	14	Angel Duarte Parroquia Ximena Mz417 Sl17	Aguilarcornelgabrela1205@gmail.com	Catolica	Ninguno	0991031947	68	68	68	5
69	Actualizar	2006-01-19	Maybell Matie	Veloz Aguilar	16	Angel Duarte Parroquia Ximena Mz417 Sl17	Aguilarcornelgabrela1205@gmail.com	Catolica	Ninguno	0991031947	69	69	69	5
70	Actualizar	2006-01-20	Gemilson Alejandro	Patino Agilar	11	Angel Duarte Parroquia Ximena Mz417 Sl17	Aguilarcornelgabrela1205@gmail.com	Catolica	Ninguno	0991031947	70	70	70	5
71	Actualizar	2006-01-21	Eliana Killar	Lastra Aguilar	4	Angel Duarte Parroquia Ximena Mz417 Sl17	Aguilarcornelgabrela1205@gmail.com	Catolica	Ninguno	0991031947	71	71	71	5
72	0951850619	2006-01-05	Mia Fiorella	Neira Ortega	16	I. Trinitaria Coop. Nelson Mandela 2 Mz 5 Solar 14	jornisse28@hotmail.com	Catolica	Ninguno	0996897718	72	72	72	3
\.


--
-- Data for Name: curso; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.curso (id_curso, nom_cur, estado_cur) FROM stdin;
1	Guitarra	t
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

COPY public.mama (id_mama, nombre_ma, est_civ_ma, lug_tra_ma, cargo_ma, tele_ma) FROM stdin;
1	Teresa Tomala	Soltera	Casa	Ama de Casa	0980627875\n
2	Teresa Tomala	Soltera	Casa	Ama de Casa	0980627875
3	Teresa Tomala	Soltera	Casa	Ama de Casa	0980627875
4	Teresa Tomala	Soltera	Casa	Ama de Casa	0980627875
5	Gabriela Bajaña	Casada	Casa	Cocinera	0967897781
6	Gabriela Bajaña	Casada	Casa	Cocinera	0967897781
7	Isabel Camacho	Casada	Casa	Ama de Casa	0967078038
8	Isabel Camacho	Casada	Casa	Ama de Casa	0967078038
9	Katherine Navarro	Divorciada	Calle	Vendedora Informal	0969920702
10	Katherine Navarro	Divorciada	Calle	Vendedora Informal	0969920702
11	Narcisa Jimenez	Soltera	Grafimpac	Engomadora	0967843640
12	Delia Arellano	Divorciada	Casa	Ama de Casa	0979742776
13	Delia Arellano	Divorciada	Casa	Ama de Casa	0979742776
14	Genesis Moreno	Soltera	Casa	Ama de Casa	0999638048
15	Andrea Reyes	Soltera	Casa	Ama de Casa	0981968233
16	Andrea Reyes	Soltera	Casa	Ama de Casa	0981968233
17	Lizbeth Peso	Soltera	Calle	Comerciante	0969493998
18	Roza Gonzales	Soltera	Local	Vendedora	0969683022
19	Maribel Vasquez	Soltera	Actualizar	Actualizar	0939534160
20	Maribel Vasquez	Soltera	Actualizar	Actualizar	0939534160
21	Maribel Vasquez	Soltera	Actualizar	Actualizar	0939534160
22	Evelyn Rodriguez	Union Libre	Casa	Ama de Casa	0995191285
23	Evelyn Rodriguez	Union Libre	Casa	Ama de Casa	0995191285
24	Evelyn Rodriguez	Union Libre	Casa	Ama de Casa	0995191285
25	Hilda Manuela Chavez Valverde	Unido	Casa	Ama de Casa	0982822771
26	Hilda Manuela Chavez Valverde	Unido	Casa	Ama de Casa	0982822771
27	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
28	Narcisa Monroy Morales	Soltera	No trabaja	Actualizar	0991633599
29	Nicole Asnalema	Soltera	No trabaja	actualizar	0991633599
30	Narcisa Monroy Morales	Soltera	No trabaja	Actualizar	0991633599
32	 Reina del Carmen Cantos Vaca	Casada	No trabaja	Actualizar	0979821304
33	Orlin Garcia	Soltera	No trabaja	Actualizar	0959420923
34	Orlin Garcia	Soltera	No trabaja	Actualizar	0959420923
35	Orlin Garcia	Soltera	No trabaja	Actualizar	0959420923
36	Actualizar	Soltera	Comerciante	Comerciante	0989575809
37	Actualizar	Soltera	Comerciante	Comerciante	0989575809
38	Actualizar	Soltera	Comerciante	Comerciante	0989575809
39	Actualizar	Casada	Actualizar	QD.	604006
40	Reina Criollo	Casada	Ama de casa	Actualizar	Actualizar
41	Reina Criollo	Casada	Ama de casa	Actualizar	Actualizar
43	Janeth Zamora	Soltera	Ama de casa	Aseo	0967942477
44	Janeth Zamora	Soltera	Ama de casa	Aseo	0967942477
47	Marjorie Beatriz  Mite Gordillo	Actualizar	Ama de casa	Actualizar	0986085808
48	Marjorie Beatriz  Mite Gordillo	Actualizar	Ama de casa / Vendedora	Actualizar	0986085808
49	Marjorie Beatriz  Mite Gordillo	Actualizar	Actualizar	Actualizar	Actualizar
50	Viviana Escalante Reyes	Soltera	Ama de casa	Actualizar	0968217085
51	Mercedes Peña	Casada	Q D	Arregla casa 3 veces a la semana	0939149714
52	Mercedes Peña	Casada	Q D	Arregla casa 3 veces a la semana	0939149714
53	Mercedes Peña	Casada	Q D	Arregla casa 3 veces a la semana	0939149714
54	Mercedes Peña	Casada	Q D	Arregla casa 3 veces a la semana	0939149714
55	Kelly	Soltera	Vendedora informal	Actualizar	0981926094
56	Kelly	Soltera	Vendedora informal	Actualizar	0981926094
57	Cinthia Rodriguez Martinez	Soltera	Decoradora de fiesta	Decoradora de fiesta	0997054352
58	Cinthia Rodriguez Martinez	Soltera	Decoradora de fiesta	Decoradora de fiesta	0997054352
59	Actualizar	Soltera	Ama de casa	Actualizar	Actualizar
60	Actualizar	Soltera	Ama de casa	Actualizar	Actualizar
61	Actualizar	Soltera	Ama de casa	Actualizar	Actualizar
62	Actualizar	Soltera	Ama de casa	Actualizar	Actualizar
63	Guilda Consuelo	Union libre	Ambulante	Comerciante	42017937
64	Guilda Consuelo	Union libre	Ambulante	Comerciante	42017937
65	Maria Caicedo	Actualizar	Actualizar	Actualizar	Actualizar
66	Kathereine Reyes	Soltera	Tienda	Ama de casa	0961354135
67	Viviana Escalante Reyes	Soltera	Ama de casa	Actualizar	0968217085
68	Gabriela Alexandra Aguilar Coronel	Actualizar	Informal	Informal	0991031947
69	Gabriela Alexandra Aguilar Coronel	Actualizar	Informal	Informal	0991031947
70	Gabriela Alexandra Aguilar Coronel	Actualizar	Informal	Informal	0991031947
71	Gabriela Alexandra Aguilar Coronel	Actualizar	Informal	Informal	0991031947
31	Actualizar	Casada	Actualizar	Actualizar	0979821304
42	Actualizar	Soltera	Ama de casa	Aseo	0988496030
45	Mariuxi Lopez Castillo	Soltera	Camal	Cocinera	0958947904
46	Mariuxi Lopez Castillo	Soltera	Camal	Cocinera	0958947904
72	Denisse	Soltera	Telconet	Programadora	0996897714
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

COPY public.papa (id_papa, nombre_pa, est_civ_pa, lug_tra_pa, cargo_pa, tele_pa) FROM stdin;
1	Luis Mocha	Soltero	Calle	Chofer	0980627875
2	Luis Mocha	Soltero	Calle	Chofer	0980627875
3	Luis Mocha	Soltero	Calle	Chofer	0980627875
4	Luis Mocha	Soltero	Calle	Chofer	0980627875
5	Francisco Salavarria	Casado	Oficial del Albamileria	Oficial	Actualizar
6	Francisco Salavarria	Casado	Oficial del Albamileria	Oficial	Actualizar
7	Cesar Espinoza	Casado	Trabajo temporario	Actualizar	0990548268
8	Cesar Espinoza	Casado	Trabajo temporario	Actualizar	0990548268
9	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
10	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
11	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
12	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
13	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
14	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
15	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
16	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
17	Actualizar	Actualizar	Zapateria	Zapatero	Actualizar
18	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
19	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
20	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
21	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
22	Jose Luzardo	Unión Libre	Camaronera	Descabezador	Actualizar
23	Jose Luzardo	Unión Libre	Camaronera	Descabezador	Actualizar
24	Jose Luzardo	Unión Libre	Camaronera	Descabezador	Actualizar
25	Ernesto Eduardo Artida Antepara	Unido	Actualizar	Vendedor ambulante	0982822771
26	Ernesto Eduardo Artida Antepara	Unido	Actualizar	Vendedor ambulante	0982822771
27	Juan Reyes	Soltero	Eventual	Actualizar	0985611995
28	Miguel Asnalema Tixe	Soltero	Ambulante	Reciclador	0991633599
29	Actualizar	Soltero	Ambulante	Actualizar	0991633599
30	Miguel Asnalema Tixe	Soltero	Ambulante	Reciclador	0991633599
31	Actualizar	Casado	Comerciante Ambulante	Actualizar	0979821304
32	Darwin Antonio Moncada Villacis	Casado	Comerciante Ambulante	Actualizar	0979821304
33	Thiago Garcia	Soltero	Duran	Soldador	0985999291
34	Thiago Garcia	Soltero	Duran	Soldador	0985999291
35	Thiago Garcia	Soltero	Duran	Soldador	0985999291
36	Actualizar	Soltero	Actualizar	Actualizar	Actualizar
37	Actualizar	Soltero	Actualizar	Actualizar	Actualizar
38	Actualizar	Soltero	Actualizar	Actualizar	Actualizar
39	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
40	Alexio Artidas	Casado	Eventual	Actualizar	Actualizar
41	Alexio Artidas	Casado	Eventual	Actualizar	Actualizar
42	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
43	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
44	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
45	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
46	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
47	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
48	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
49	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
50	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
51	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
52	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
53	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
54	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
55	Actualizar	Actualizar	Comerciante	Actualizar	0981926094
56	Actualizar	Actualizar	Comerciante	Actualizar	0981926094
57	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
58	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
59	Actualizar	Soltero	Bahia	Vendedor ambulante	Actualizar
60	Actualizar	Soltero	Bahia	Vendedor ambulante	Actualizar
61	Actualizar	Soltero	Bahia	Vendedor ambulante	Actualizar
62	Actualizar	Soltero	Bahia	Vendedor ambulante	Actualizar
63	Oscar Sandoval	Union libre	Ambulante	Comerciante	42017937
64	Oscar Sandoval	Union libre	Ambulante	Comerciante	42017937
65	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
66	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
67	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
68	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
69	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
70	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
71	Actualizar	Actualizar	Actualizar	Actualizar	Actualizar
72	Jorge	Soltero	Telconet	Programadoro	0996897719
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

SELECT pg_catalog.setval('public.sec_cur', 1, true);


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

SELECT pg_catalog.setval('public.sec_socieco', 72, true);


--
-- Name: sec_soeco; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec_soeco', 72, true);


--
-- Name: sec_usuarios; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sec_usuarios', 3, true);


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
-- Name: usuarios usuarios_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuarios
    ADD CONSTRAINT usuarios_pkey PRIMARY KEY (id_user);


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
-- Name: beneficiario fkpadres; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.beneficiario
    ADD CONSTRAINT fkpadres FOREIGN KEY (id_padres) REFERENCES public.padres(id_padres);


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
-- PostgreSQL database dump complete
--


create table empresa_ref
(
    id        integer default nextval('empresa_id_seq'::regclass) not null,
    nome      varchar(50)                                         not null
        constraint empresa_pkey
            primary key,
    cnpj      varchar(19)
        constraint empresa_cnpj_unique
            unique
        constraint empresa_pk
            unique,
    habilitar boolean
);

alter table empresa_ref
    owner to postgres;

create table trabalhador
(
    id            serial,
    nome          varchar(50),
    rfid          varchar(15),
    tipo          varchar(40),
    habilitar     boolean,
    matricula     varchar(10) not null
        constraint matricula_pk
            primary key,
    empresa       varchar(25)
        constraint trabalhador_empresa_nome_fk
            references empresa_ref,
    "nome_emp_FK" integer
);

alter table trabalhador
    owner to postgres;

create table cc_ref
(
    id        integer default nextval('custos_id_seq'::regclass) not null,
    codigo    varchar(7)                                         not null
        constraint codigo
            primary key,
    descricao varchar(30)
        constraint descricao
            unique
);

alter table cc_ref
    owner to postgres;

create table categoria_ref
(
    id    integer default nextval('categoria_id_seq'::regclass) not null,
    sigla varchar(3)                                            not null
        constraint categoria_ref_pk
            unique,
    nome  varchar(25)
);

alter table categoria_ref
    owner to postgres;

create table equipamento
(
    id            serial,
    tag           varchar(10) not null
        constraint tag_pk
            primary key,
    categoria_ref varchar(20),
    rfid          varchar,
    habilitar     boolean,
    empresa_ref   varchar(25)
        constraint equipamento_empresa_nome_fk
            references empresa_ref,
    cc_ref        varchar(7)
        constraint "cod_cus_FK"
            references cc_ref,
    placa         varchar(8),
    marca         varchar(25),
    cnpj          varchar(19)
        constraint equipamento_empresa_cnpj_fk
            references empresa_ref (cnpj),
    sigla_cat_fk  varchar(3)
        constraint equipamento_categoria_sigla_fk
            references categoria_ref (sigla),
    descricao     varchar(30)
        constraint equipamento_custos_descricao_fk
            references cc_ref (descricao)
);

alter table equipamento
    owner to postgres;

create table abatecimento_posto
(
    id                 serial,
    data_abastecimento date,
    litros             double precision,
    tag_eqp_fk         varchar(10)
        references equipamento,
    mat_tra_fk         varchar(10)
        references trabalhador,
    cod_cc_fk          varchar(7)
        references cc_ref
);

alter table abatecimento_posto
    owner to postgres;

create table posto_ref
(
    id          serial,
    tipo        varchar(8),
    descricao   varchar(25),
    sigla       varchar(3),
    tag_eqp_fk varchar(10)
        references equipamento
);

alter table posto_ref
    owner to postgres;



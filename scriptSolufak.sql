ALTER TABLE proveedor ADD COLUMN dias_credito numeric(10,0) NOT NULL
ALTER TABLE detalle_ingreso_mercaderia ADD COLUMN servicio numeric(10,0) NOT NULL
-- Table: proveedor

-- DROP TABLE proveedor;

CREATE TABLE proveedor
(
  cedula character varying(50) NOT NULL,
  nombre character varying(50) NOT NULL,
  telefono_1 character varying(50) NOT NULL,
  telefono_2 character varying(50),
  email character varying(50),
  direccion character varying(150),
  dias_credito numeric(10,0) NOT NULL,
  monto_credito numeric(10,0) NOT NULL,
  CONSTRAINT pk_proveedor PRIMARY KEY (cedula)
)
WITH (
  OIDS=FALSE
);
-- Table: categoria_articulo

-- DROP TABLE proveedor;

CREATE TABLE categoria_articulo
(
  cod_categoria character varying(50) NOT NULL,
  descripcion character varying(50) NOT NULL,
  CONSTRAINT pk_categoria_articulo PRIMARY KEY (cod_categoria)
)
WITH (
  OIDS=FALSE
);
-- Table: articulo

-- DROP TABLE articulo;

CREATE TABLE articulo
(
  cod_articulo character varying(50) NOT NULL,
  descripcion character varying(50) NOT NULL,
  cod_categoria character varying(50) NOT NULL,
  precio_venta numeric(10,0),
  CONSTRAINT pk_articulo PRIMARY KEY (cod_articulo),
  CONSTRAINT pk_categoria_articulo FOREIGN KEY (cod_categoria)
      REFERENCES categoria_articulo (cod_categoria) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- Table: cliente

-- DROP TABLE cliente;

CREATE TABLE cliente
(
  cedula_cliente character varying(50) NOT NULL,
  nombre character varying(50) NOT NULL,
  apellido1 character varying(50) NOT NULL,
  apellido2 character varying(50),
  telefono character varying(50),
  correo_electronico character varying(50),
  direccion character varying(150),
  CONSTRAINT pk_cliente PRIMARY KEY (cedula_cliente)
)
WITH (
  OIDS=FALSE
);

-- Table: tipo_pago
-- DROP TABLE tipo_pago;
CREATE TABLE tipo_pago
(
  num_pago character varying(50) NOT NULL,
  descripcion character varying(50) NOT NULL,
  CONSTRAINT pk_tipo_pago PRIMARY KEY (num_pago)
)
WITH (
  OIDS=FALSE
);

-- Table: stock

-- DROP TABLE stock;

CREATE TABLE stock
(
  cod_articulo character varying(50) NOT NULL,
  existencias numeric(50,0) NOT NULL,
  CONSTRAINT pk_stock PRIMARY KEY (cod_articulo),
  CONSTRAINT fk_articulo FOREIGN KEY (cod_articulo)
      REFERENCES articulo (cod_articulo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- Table: ingreso_mercaderia

-- DROP TABLE ingreso_mercaderia;

CREATE TABLE ingreso_mercaderia
(
  num_factura character varying(50) NOT NULL,
  cedula_proveedor character varying(50),
  fecha_ingreso timestamp without time zone NOT NULL,
  CONSTRAINT pk_ingreso_mercaderia PRIMARY KEY (num_factura),
  CONSTRAINT fk_proveedor FOREIGN KEY (cedula_proveedor)
      REFERENCES proveedor (cedula) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- Table: detalle_ingreso_mercaderia

-- DROP TABLE detalle_ingreso_mercaderia;

CREATE TABLE detalle_ingreso_mercaderia
(
  num_detalle character varying(50) NOT NULL,
  num_factura character varying(50) NOT NULL,
  cod_articulo character varying(50) NOT NULL,
  cantidad numeric(10,0) NOT NULL,
  subtotal numeric(10,0) NOT NULL,
  descuento numeric(10,0) NOT NULL,
  CONSTRAINT pk_detalle_ingreso_mercaderia PRIMARY KEY (num_detalle),
  CONSTRAINT fk_ingreso_mercaderia FOREIGN KEY (num_factura)
      REFERENCES ingreso_mercaderia (num_factura) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_articulo FOREIGN KEY (cod_articulo)
      REFERENCES articulo (cod_articulo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- Table: factura_contado

-- DROP TABLE factura_contado;

CREATE TABLE factura_contado
(
  num_factura character varying(50) NOT NULL,
  cedula_cliente character varying(50) NOT NULL,
  fecha_factura timestamp without time zone NOT NULL,
  num_pago character varying(50) NOT NULL,
  CONSTRAINT pk_factura_contado PRIMARY KEY (num_factura),
  CONSTRAINT fk_tipo_pago FOREIGN KEY (num_pago)
      REFERENCES tipo_pago (num_pago) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_cliente FOREIGN KEY (cedula_cliente)
      REFERENCES cliente (cedula_cliente) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
-- Table: factura_credito

-- DROP TABLE factura_credito;

CREATE TABLE factura_credito
(
  num_factura character varying(50) NOT NULL,
  cedula_cliente character varying(50),
  fecha_factura timestamp without time zone NOT NULL,
  dias_credito numeric(10,0) NOT NULL,
  CONSTRAINT pk_factura_credito PRIMARY KEY (num_factura),
  CONSTRAINT fk_cliente FOREIGN KEY (cedula_cliente)
      REFERENCES cliente (cedula_cliente) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);

-- Table: detalle_factura_contado

-- DROP TABLE detalle_factura_contado;

CREATE TABLE detalle_factura_contado
(
  num_detalle character varying(50) NOT NULL,
  num_factura character varying(50) NOT NULL,
  cod_articulo character varying(50) NOT NULL,
  cantidad numeric(10,0) NOT NULL,
  subtotal numeric(10,0) NOT NULL,
  descuento numeric(10,0) NOT NULL,
  CONSTRAINT pk_detalle_factura_contado PRIMARY KEY (num_detalle),
  CONSTRAINT fk_factura_contado FOREIGN KEY (num_factura)
      REFERENCES factura_contado (num_factura) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_articulo FOREIGN KEY (cod_articulo)
      REFERENCES articulo (cod_articulo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
-- Table: detalle_factura_credito

-- DROP TABLE detalle_factura_credito;

CREATE TABLE detalle_factura_credito
(
  num_detalle character varying(50) NOT NULL,
  num_factura character varying(50) NOT NULL,
  cod_articulo character varying(50) NOT NULL,
  cantidad numeric(10,0) NOT NULL,
  subtotal numeric(10,0) NOT NULL,
  descuento numeric(10,0) NOT NULL,
  CONSTRAINT pk_detalle_factura_credito PRIMARY KEY (num_detalle),
  CONSTRAINT fk_factura_credito FOREIGN KEY (num_factura)
      REFERENCES factura_credito (num_factura) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_articulo FOREIGN KEY (cod_articulo)
      REFERENCES articulo (cod_articulo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
-- Table: credito_cliente

-- DROP TABLE credito_cliente;

CREATE TABLE credito_cliente
(
  num_factura character varying(50) NOT NULL,
  cedula_cliente character varying(50) NOT NULL,
  dias_credito numeric(10,0) NOT NULL,
  saldo numeric(10,0) NOT NULL,
  CONSTRAINT pk_credito_cliente PRIMARY KEY (num_factura),
  CONSTRAINT fk_factura_credito FOREIGN KEY (num_factura)
      REFERENCES factura_credito (num_factura) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_cliente FOREIGN KEY (cedula_cliente)
      REFERENCES cliente (cedula_cliente) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
-- Table: abono

-- DROP TABLE abono;

CREATE TABLE abono
(
  num_abono character varying(50) NOT NULL,
  cedula_cliente character varying(50) NOT NULL,
  fecha_abono timestamp without time zone NOT NULL,
  monto numeric(10,0) NOT NULL,
  CONSTRAINT pk_abono PRIMARY KEY (num_abono),
  CONSTRAINT fk_cliente FOREIGN KEY (cedula_cliente)
      REFERENCES cliente (cedula_cliente) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
-- Table: parametro_general

-- DROP TABLE parametro_general;

CREATE TABLE parametro_general
(
  id integer,
  nombre_empresa character varying(50) NOT NULL,
  impuesto_ventas integer,
  archivo bytea,
  CONSTRAINT pk_parametro_general PRIMARY KEY(id)
)
WITH (
  OIDS=FALSE
);

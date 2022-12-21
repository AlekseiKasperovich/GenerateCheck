create table IF NOT EXISTS checks  (id int8 not null, cashier varchar(255) not null, price_with_tax numeric(19, 2) not null, printed timestamp not null, promotional_discount numeric(19, 2), tax numeric(19, 2) not null, taxable_price numeric(19, 2) not null, total_price numeric(19, 2) not null, wholesale_discount numeric(19, 2), discount_card_id int8, primary key (id));
create table IF NOT EXISTS checks_items (check_id int8 not null, items_id int8 not null, primary key (check_id, items_id));
create table IF NOT EXISTS discount_cards (id int8 not null, discount numeric(19, 2) not null, email varchar(255) not null, first_name varchar(255) not null, last_name varchar(255) not null, primary key (id));
create table IF NOT EXISTS items (id int8 not null, qty int4 not null, total numeric(19, 2) not null, wholesale_discount numeric(19, 2), product_id int8 not null, primary key (id));
create table IF NOT EXISTS products (id int8 not null, description varchar(255) not null, price numeric(19, 2) not null, primary key (id));
ALTER TABLE checks_items DROP CONSTRAINT IF EXISTS UK_p8s31on03g7broln05blpx038;
alter table if exists checks_items add constraint UK_p8s31on03g7broln05blpx038 unique (items_id);
ALTER TABLE discount_cards DROP CONSTRAINT IF EXISTS UK_docyolaaja2h3hv8octquynx6;
alter table if exists discount_cards add constraint UK_docyolaaja2h3hv8octquynx6 unique (email);
ALTER TABLE products DROP CONSTRAINT IF EXISTS UK_8nj97xe4vc5jmbxk2skrr0fam;
alter table if exists products add constraint UK_8nj97xe4vc5jmbxk2skrr0fam unique (description);
ALTER TABLE checks DROP CONSTRAINT IF EXISTS FKmjgsla72b7xnamg0wcjbpvncd;
alter table if exists checks add constraint FKmjgsla72b7xnamg0wcjbpvncd foreign key (discount_card_id) references discount_cards;
ALTER TABLE checks_items DROP CONSTRAINT IF EXISTS FK6k49c57nnydt1ypgrm1yqk6n7;
alter table if exists checks_items add constraint FK6k49c57nnydt1ypgrm1yqk6n7 foreign key (items_id) references items;
ALTER TABLE checks_items DROP CONSTRAINT IF EXISTS FKnif327ogjo3633pwu02la761a;
alter table if exists checks_items add constraint FKnif327ogjo3633pwu02la761a foreign key (check_id) references checks;
ALTER TABLE items DROP CONSTRAINT IF EXISTS FKmtk37pxnx7d5ck7fkq2xcna4i;
alter table if exists items add constraint FKmtk37pxnx7d5ck7fkq2xcna4i foreign key (product_id) references products;
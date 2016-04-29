# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table location (
  id                        bigserial not null,
  latitude                  varchar(255),
  longitude                 varchar(255),
  user_id                   bigint,
  TIME_IN_MILLIS            varchar(255),
  constraint pk_location primary key (id))
;

create table PHONE_LOG (
  id                        bigserial not null,
  PHONE_NUMBER              varchar(255),
  DURATION                  varchar(255),
  CALL_TYPE                 varchar(8),
  user_id                   bigint,
  TIME_IN_MILLIS            varchar(255),
  constraint ck_PHONE_LOG_CALL_TYPE check (CALL_TYPE in ('INCOMING','OUTGOING')),
  constraint pk_PHONE_LOG primary key (id))
;

create table SMS_LOG (
  id                        bigserial not null,
  PHONE_NUMBER              varchar(255),
  SMS_TEXT                  TEXT,
  SMS_TYPE                  varchar(8),
  user_id                   bigint,
  TIME_IN_MILLIS            varchar(255),
  constraint ck_SMS_LOG_SMS_TYPE check (SMS_TYPE in ('INCOMING','OUTGOING')),
  constraint pk_SMS_LOG primary key (id))
;

create table APP_USERS (
  id                        bigserial not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  EMAIL_ID                  varchar(255),
  PASSWORD                  varchar(255),
  USER_TYPE                 varchar(6),
  constraint ck_APP_USERS_USER_TYPE check (USER_TYPE in ('PARENT','CHILD')),
  constraint uq_APP_USERS_EMAIL_ID unique (EMAIL_ID),
  constraint pk_APP_USERS primary key (id))
;

alter table location add constraint fk_location_user_1 foreign key (user_id) references APP_USERS (id);
create index ix_location_user_1 on location (user_id);
alter table PHONE_LOG add constraint fk_PHONE_LOG_user_2 foreign key (user_id) references APP_USERS (id);
create index ix_PHONE_LOG_user_2 on PHONE_LOG (user_id);
alter table SMS_LOG add constraint fk_SMS_LOG_user_3 foreign key (user_id) references APP_USERS (id);
create index ix_SMS_LOG_user_3 on SMS_LOG (user_id);



# --- !Downs

drop table if exists location cascade;

drop table if exists PHONE_LOG cascade;

drop table if exists SMS_LOG cascade;

drop table if exists APP_USERS cascade;


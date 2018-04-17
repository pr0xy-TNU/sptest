-- create role--
create table role
(
  id          int not null,
  role_name   varchar(80),
  role_salary double,
  role_code   int not null,
  user_id     int,
  primary key (id),
  index fk_user_id(user_id),
  constraint fk_user_id foreign key (user_id) references employees (id)
    on delete cascade
    on update cascade
)
  engine = InnoDB;

--create user_role--
create table role_employee
(
  employee_id int,
  role_id int,
  index fkrandomforuserid(employee_id),
  index fkrandomforroleid(role_id),
  primary key (user_id, role_id),
  constraint foreign key (employee_id) references employees (employee_id)
    on UPDATE cascade
    on delete cascade,
  constraint foreign key (role_id) references player_role (id)
    on update cascade
    on delete cascade
) engine = InnoDB;

--data to employee table--
insert into employees (employee_name, employee_age, employee_adress)values
('Shon', 32, 'some address'),
('Shon', 45, 'some address'),
('Linda', 38, 'Voll streen'),
('Hick', 87, 'test address'),
('Jeff', 62, 'bomg');

--data to role table--
insert into player_role (role_name, role_salary, role_code) values
('director', 32000, 9307),
('manager', 45000, 9308),
('courier', 38000, 9309),
('cassir', 87000, 9307),
('some role', 62000, 9305);

---data role_employee table --
insert into role_employee(employee_id, role_id) values
  (1,7),
  (1,8),
  (2,9),
  (3,10),
  (5,11),
  (2,9),
  (5,8),
  (3,7),
  (3,10),
  (1,9);

--User data--
insert into player(player_address, player_age, player_name, player_email) VALUES
  ('Bespalova 45a', 25, 'Yarik', 'ya@yandex.ru'),
  ('Bespalova 45a', 19, 'Didi', 'didi@yandex.ru'),
  ('SHkolnaya 39/4', 48, 'Luda', 'lola@yandex.ru'),
  ('Belakuna 15', 21, 'Misha', 'test@yandex.ru'),
  ('bespalova 45a', 12, 'Yarik', 'lllc@mail.com');

--Account table--
insert into account (login, password, last_data_enter, player_id) values
  ('vip2010', '11223344', NOW(), 1),
  ('cspro100', '99234953', NOW(), 2),
  ('nikck', '11223344', NOW(), 3),
  ('lenski12', '11223344', NOW(), 4),
  ('yandexroom', '11223344', NOW(), 5);

--Join --
select
  pl.player_id,
  pl.player_name,
  pl.player_email,
  acc.last_data_enter,
  plrol.role_name
from player as pl
  inner join account as acc on pl.player_id = acc.player_id
  inner join player_role as plrol on plrol.player_id = acc.player_id;

-- Role table--
create table role (
  id          int not null default 0,
  role_name   varchar(80),
  role_salary double       default 0.0,
  role_code   int(11),
  primary key (id)
) engine = InnoDB;
--Games table--
create table games (
  game_id      int         not null auto_increment,
  game_name    varchar(80) not null,
  game_price   double      not null,
  game_company varchar(80) not null,
  primary key (game_id),
  player_id    int         not null,
  constraint fk_game_player_id
  foreign key (player_id) references player (player_id)
    on UPDATE cascade
    on DELETE cascade,
  index (player_id)
)
  engine = InnoDB;
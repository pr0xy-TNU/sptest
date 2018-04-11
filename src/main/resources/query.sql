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
  constraint foreign key (role_id) references role (id)
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
insert into role (role_name, role_salary, role_code) values
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
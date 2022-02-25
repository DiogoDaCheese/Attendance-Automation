create table if not exists STUDENT (
                         id INT AUTO_INCREMENT,
                         name VARCHAR(50),
                         PRIMARY KEY (id)
);
insert into STUDENT (name) values ('Colette Goodlett');
insert into STUDENT (name) values ('Ediva Brandrick');
insert into STUDENT (name) values ('Nari Barwis');
insert into STUDENT (name) values ('Cthrine Kefford');
insert into STUDENT (name) values ('Kacy Dobbison');
insert into STUDENT (name) values ('Lyndsie Moscon');
insert into STUDENT (name) values ('Royal Porson');
insert into STUDENT (name) values ('Sonya Coomes');
insert into STUDENT (name) values ('Amil Markushkin');
insert into STUDENT (name) values ('Carine Ramme');
insert into STUDENT (name) values ('Jory Hackelton');
insert into STUDENT (name) values ('Geralda Gopsall');
insert into STUDENT (name) values ('Oriana Toulamain');
insert into STUDENT (name) values ('Cassandry Gillian');
insert into STUDENT (name) values ('Zach Vanns');
insert into STUDENT (name) values ('Ethelbert Richards');
insert into STUDENT (name) values ('Zollie Cherm');
insert into STUDENT (name) values ('Arther Seares');
insert into STUDENT (name) values ('Vere Gatecliff');
insert into STUDENT (name) values ('Rozanna Picardo');


/*create table if not exists CLASS (
                       id INT AUTO_INCREMENT,
                       name VARCHAR(50),
                       weekday VARCHAR(50),
                       PRIMARY KEY (id)
);
insert into CLASS (name, weekday) values ('SCO2.B.22', 'Monday');
insert into CLASS (name, weekday) values ('SDE2.B.22', 'Tuesday');
insert into CLASS (name, weekday) values ('SCO2.B.22', 'Wednesday');
insert into CLASS (name, weekday) values ('DBOS.AB.22', 'Thursday');
insert into CLASS (name, weekday) values ('ITO2.AB.22', 'Thursday');
insert into CLASS (name, weekday) values ('SCO2.B.22', 'Friday');*/

create table if not exists CLASS (
                                     id INT AUTO_INCREMENT,
                                     name VARCHAR(50),
                                     PRIMARY KEY (id)
);
insert into CLASS (name) values ('SCO2.B.22');
insert into CLASS (name) values ('SDE2.B.22');
insert into CLASS (name) values ('DBOS.AB.22');
insert into CLASS (name) values ('ITO2.AB.22');

create table if not exists ATTENDANCE (
                                          student_id INT,
                                          subject_id INT,
                                          date DATE,
                                          attended BOOLEAN
);
insert into ATTENDANCE (student_id, subject_id, date, attended) values (1, 1, '2021-2-25', true);
insert into ATTENDANCE (student_id, subject_id, date, attended) values (2, 2, '2021-2-10', false);
insert into ATTENDANCE (student_id, subject_id, date, attended) values (3, 3, '2021-11-26', true);
insert into ATTENDANCE (student_id, subject_id, date, attended) values (4, 4, '2021-2-10', false);
insert into ATTENDANCE (student_id, subject_id, date, attended) values (5, 1, '2021-3-1', true);
insert into ATTENDANCE (student_id, subject_id, date, attended) values (6, 2, '2021-10-25', false);
insert into ATTENDANCE (student_id, subject_id, date, attended) values (7, 1, '2021-11-28', true);
insert into ATTENDANCE (student_id, subject_id, date, attended) values (8, 2, '2021-7-4', false);
insert into ATTENDANCE (student_id, subject_id, date, attended) values (9, 3, '2021-11-13', true);
insert into ATTENDANCE (student_id, subject_id, date, attended) values (10, 4, '2021-3-25', false);
insert into ATTENDANCE (student_id, subject_id, date, attended) values (11, 3, '2022-2-7', true);
insert into ATTENDANCE (student_id, subject_id, date, attended) values (12, 4, '2021-9-29', false);
insert into ATTENDANCE (student_id, subject_id, date, attended) values (13, 1, '2021-5-5', true);
insert into ATTENDANCE (student_id, subject_id, date, attended) values (14, 2, '2021-11-19', false);
insert into ATTENDANCE (student_id, subject_id, date, attended) values (15, 3, '2021-10-11', true);

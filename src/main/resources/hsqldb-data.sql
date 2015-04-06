-- person
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Chancellor');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Araiza');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Marksberry');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Mandujano');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Cyr');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Mobley');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Cottrell');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Poythress');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Siniard');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Mccord');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Boulton');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Allred');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Kehr');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Mathieson');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Lininger');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Lambson');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Mcqueeney');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Parramore');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Eckenrode');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Marx');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Cooper');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Dabney');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Brickey');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Mazzarella');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Wendler');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Mcanulty');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Nava');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Wolfenbarger');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Cosby');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Bachus');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Scheele');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Bogan');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Macha');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Llewellyn');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Witty');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Thweatt');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Mooring');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Akin');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Allsup');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Syring');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Uzzle');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Lenahan');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Tack');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Leff');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Goodson');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Gerrard');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Banta');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Bartling');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Loya');
INSERT INTO person (person_id,person_name) VALUES (DEFAULT,'Mericle');

-- department
INSERT INTO department (department_id, department_name) VALUES (DEFAULT, 'Athletics');

INSERT INTO department (department_id, department_name) VALUES (DEFAULT, 'Computer');

INSERT INTO department (department_id, department_name) VALUES (DEFAULT, 'English');

INSERT INTO department (department_id, department_name) VALUES (DEFAULT, 'Fine Arts');

INSERT INTO department (department_id, department_name) VALUES (DEFAULT, 'Information Technology');

INSERT INTO department (department_id, department_name) VALUES (DEFAULT, 'Math');

INSERT INTO department (department_id, department_name) VALUES (DEFAULT, 'Music');

INSERT INTO department (department_id, department_name) VALUES (DEFAULT, 'Nurse');

INSERT INTO department (department_id, department_name) VALUES (DEFAULT, 'Science');

INSERT INTO department (department_id, department_name) VALUES (DEFAULT, 'Social Studies');


-- section
INSERT INTO section (section_id, section_name, department_id) VALUES (DEFAULT, '1000',3);
INSERT INTO section (section_id, section_name, department_id) VALUES (DEFAULT, '2000',3);
INSERT INTO section (section_id, section_name, department_id) VALUES (DEFAULT, '3000',4);
INSERT INTO section (section_id, section_name, department_id) VALUES (DEFAULT, '4000',5);

-- office 
INSERT INTO office (office_id, office_name) VALUES (DEFAULT,'Admission');
INSERT INTO office (office_id, office_name) VALUES (DEFAULT,'Bursar');
INSERT INTO office (office_id, office_name) VALUES (DEFAULT,'Registra');

-- Student
INSERT INTO student (person_id,student_id) VALUES (2,DEFAULT);
INSERT INTO student (person_id,student_id) VALUES (34,DEFAULT);
INSERT INTO student (person_id,student_id) VALUES (22,DEFAULT);
INSERT INTO student (person_id,student_id) VALUES (18,DEFAULT);

-- Staff
INSERT INTO staff (person_id, staff_id, office_id) VALUES (30,DEFAULT,1);
INSERT INTO staff (person_id, staff_id, office_id) VALUES (40,DEFAULT,1);
INSERT INTO staff (person_id, staff_id, office_id) VALUES (13,DEFAULT,2);
INSERT INTO staff (person_id, staff_id, office_id) VALUES (17,DEFAULT,0);

-- registry
INSERT INTO registry (registry_id,section_id,student_id) VALUES (DEFAULT,1,1);
INSERT INTO registry (registry_id,section_id,student_id) VALUES (DEFAULT,1,2);
INSERT INTO registry (registry_id,section_id,student_id) VALUES (DEFAULT,1,3);
INSERT INTO registry (registry_id,section_id,student_id) VALUES (DEFAULT,2,1);
INSERT INTO registry (registry_id,section_id,student_id) VALUES (DEFAULT,2,0);

-- attendance
INSERT INTO attendance (attendance_id,attendance_type) VALUES (0,'present');
INSERT INTO attendance (attendance_id,attendance_type) VALUES (1,'absent');
INSERT INTO attendance (attendance_id,attendance_type) VALUES (2,'leave');

create database usm;
use usm;
create table login(username varchar(30), password varchar(30));
select * from login;
insert into login values('pratham','******');

-- add faculty and to check if added successfully
create table teacher(name varchar(40),fname varchar(40),empID varchar(40),dob varchar(40),address varchar(40), phone varchar(40), email varchar(40), class_X varchar(40), class_XII varchar(40), aadhaar varchar(40), education varchar(40), department varchar(40));
select * from teacher;

-- add student and to check if added successfully
create table student(name varchar(40),fname varchar(40),rollno varchar(40),dob varchar(40),address varchar(40), phone varchar(40), email varchar(40), class_X varchar(40), class_XII varchar(40), aadhaar varchar(40), course varchar(40), branch varchar(40));
select * from student;

-- student leave 
create table studentleave(rollno varchar(20),date varchar(20), time varchar(20));
select * from studentleave;

-- teacher leave
create table teacherleave(empID varchar(20),date varchar(20), time varchar(20));
select * from teacherleave;

-- show subject table
create table subject(rollno varchar(20), sem varchar(20), sub1 varchar(50), sub2 varchar(50), sub3 varchar(50), sub4 varchar(50), sub5 varchar(50));
alter table subject change column sem semester varchar(20);
select * from subject;

-- show marks table
create table marks(rollno varchar(20), semester varchar(20), mrk1 varchar(50), mrk2 varchar(50), mrk3 varchar(50), mrk4 varchar(50), mrk5 varchar(50));
select * from marks;

-- fee table
create table fee(course varchar(20), semester1 varchar(20), semester2 varchar(20), semester3 varchar(20), semester4 varchar(20), semester5 varchar(20), semester6 varchar(20), semester7 varchar(20), semester8 varchar(20));
select * from fee;
insert into fee values("BE", "48000", "43000", "43000", "43000", "43000", "43000", "43000", "43000");
insert into fee values("BTech", "40000", "35000", "35000", "35000", "35000", "35000", "35000", "35000");
insert into fee values("BSC", "39000", "34000", "34000", "34000", "34000", "34000", "34000", "34000");
insert into fee values("BBA", "70000", "60000", "60000", "60000", "60000", "60000", "60000", "60000");
insert into fee values("BCA", "44000", "45000", "45000", "45000", "45000", "45000", "45000", "45000");

-- college fee
create table feecollege(rollno varchar(20), course varchar(20), branch varchar(20), semester varchar(20), total varchar(20));
select * from feecollege;

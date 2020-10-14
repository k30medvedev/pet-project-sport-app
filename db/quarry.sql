INSERT INTO sportsmans (first_name,last_name,email,birthday) 
VALUES 
( 'Sergey','Tiahovskiy','serggomel@gmail.com','1976-03-15'),
( 'Maskim','Znak','max911@gmail.com','1984-02-13'),
( 'Mariya','Kolesnikova','Mary@gmail.com','1980-03-01'),
( 'Svetlana','Tihanovskaya','sveta@gmail.com','1980-02-15'),
( 'Viktor','Babariko','viktorminsk@gmail.com','1975-01-01');

INSERT INTO runs (start_run,finish_run,distance,sportsman_id)
SELECT '2020-10-13 18:05:06 +3:00','2020-10-13 18:40:06 +3:00',120.02, id
FROM sportsmans WHERE email='serggomel@gmail',
SELECT '2020-10-12 15:05:06 +3:00','2020-10-12 15:40:06 +3:00',120.40,1,id
FROM sportsmans WHERE email=max911@gmail,
SELECT '2020-10-14 12:05:06 +3:00','2020-10-14 12:40:06 -8:00',114.50,2,id
FROM sportsmans WHERE email=sveta@gmail,
SELECT '2020-10-21 11:05:06 +3:00','2020-10-21 11:40:06 +3:00',402.00,3,id
FROM sportsmans WHERE email=viktorminsk@gmail,
SELECT '2020-10-13 14:05:06 +3:00','2020-10-13 14:40:06 +3:00',303.04,4,id
FROM sportsmans WHERE email=serggomel@gmail,
SELECT '2020-10-13 14:05:06 +3:00','2020-10-13 14:40:06 +3:00',122.54,4,id



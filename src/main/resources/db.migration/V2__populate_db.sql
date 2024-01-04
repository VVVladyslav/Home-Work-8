INSERT INTO "PUBLIC"."WORKER" VALUES
(12, 'John', DATE '2020-07-11', 'Trainee', 800),
(13, 'Jane', DATE '2001-02-12', 'Junior', 900),
(14, 'Jim', DATE '2005-02-13', 'Middle', 1800),
(15, 'Joe', DATE '2010-05-14', 'Senior', 1900),
(16, 'Jamal', DATE '2010-10-15', 'Senior', 1000),
(17, 'Jocker', DATE '2009-10-16', 'Senior', 1100),
(18, 'Janister', DATE '2007-11-17', 'Senior', 1200),
(19, 'Jupiter', DATE '2004-12-18', 'Middle', 5000),
(20, 'Jimison', DATE '2003-03-19', 'Trainee', 5200),
(21, 'Jared', DATE '2000-01-13', 'Middle', 1300);
INSERT INTO "PUBLIC"."CLIENT" VALUES
(1, 'Oleg Cl'),
(2, 'Olyena Cl'),
(3, 'Oksana Cl'),
(4, 'Oman Cl'),
(5, 'Omrika Cl');
INSERT INTO "PUBLIC"."PROJECT" VALUES
(1, 1, DATE '2000-01-01', DATE '2001-06-30'),
(2, 2, DATE '2000-02-15', DATE '2002-11-30'),
(3, 3, DATE '2000-06-10', DATE '2003-02-20'),
(4, 4, DATE '2003-07-20', DATE '2004-01-10'),
(5, 5, DATE '2004-03-05', DATE '2005-04-20');
INSERT INTO "PUBLIC"."PROJECT_WORKER" VALUES
(1, 20),
(1, 12),
(2, 13),
(2, 14),
(2, 15),
(3, 16),
(4, 17),
(5, 18),
(5, 19),
(5, 21);

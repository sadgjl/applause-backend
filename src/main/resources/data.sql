DROP TABLE IF EXISTS bugs;
DROP TABLE IF EXISTS testers;
DROP TABLE IF EXISTS devices;
DROP TABLE IF EXISTS tester_devices;

CREATE TABLE bugs AS SELECT * FROM CSVREAD('src/main/resources/bugs_(15)_(1).csv');
CREATE TABLE testers AS SELECT * FROM CSVREAD('src/main/resources/testers_(15)_(1).csv');
CREATE TABLE devices AS SELECT * FROM CSVREAD('src/main/resources/devices_(16)_(1).csv');
CREATE TABLE tester_devices AS SELECT * FROM CSVREAD('src/main/resources/tester_device_(16)_(1).csv');

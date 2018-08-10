/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  LAHIRU SASANKA
 * Created: Aug 9, 2018
 */
drop database sms;
create database sms;
use sms;
CREATE TABLE student(
	sid int ,
	sName VARCHAR(100),
	address VARCHAR(500),
	email VARCHAR(100),
        tell VARCHAR(100),
	CONSTRAINT PRIMARY KEY(sid)
);

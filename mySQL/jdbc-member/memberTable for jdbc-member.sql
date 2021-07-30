CREATE TABLE project.`member` (
  `ID` varchar(20) NOT NULL,
  `PW` varchar(20) COLLATE utf8_bin default NULL,
  `NAME` varchar(20) COLLATE utf8_bin default null,
  `REGDATE` varchar(20) collate utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`)
);

INSERT INTO project.MEMBER VALUES ('sera', 'sera1234', 'SeraWI','2021-07-21');
INSERT INTO project.MEMBER VALUES ('park123', 'park1234', 'Park','2020-05-05');
INSERT INTO project.MEMBER VALUES ('Lee77', 'lee9876', 'Lee','2014-04-16');

commit;
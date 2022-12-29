drop table  if exists `test`;
create table `test` (
    `id` char(8) not null default '' comment 'id',
    `name` varchar(50) comment '名称',
    primary key (`id`)
)engine =innodb default charset =utf8mb4 comment '测试';

drop table if exists `chapter`;
create table `chapter`(
    `id` char(8) not null comment 'ID',
    `course_id` char(8) comment '课程id',
`name` varchar(50) comment '名称',
primary key (`id`)
)engine = innodb default charset = utf8mb4 comment = '大章';
insert into `chapter` (id, course_id, name) values ('00000001','00000000','测试大章01');
insert into `chapter` (id, course_id, name) values ('00000002','00000000','测试大章02');
insert into `chapter` (id, course_id, name) values ('00000003','00000000','测试大章03');
insert into `chapter` (id, course_id, name) values ('00000004','00000000','测试大章04');
insert into `chapter` (id, course_id, name) values ('00000005','00000000','测试大章05');
insert into `chapter` (id, course_id, name) values ('00000006','00000000','测试大章06');
insert into `chapter` (id, course_id, name) values ('00000007','00000000','测试大章07');
insert into `chapter` (id, course_id, name) values ('00000008','00000000','测试大章08');
insert into `chapter` (id, course_id, name) values ('00000009','00000000','测试大章09');
insert into `chapter` (id, course_id, name) values ('00000010','00000000','测试大章10');
insert into `chapter` (id, course_id, name) values ('00000011','00000000','测试大章11');
insert into `chapter` (id, course_id, name) values ('00000012','00000000','测试大章12');
insert into `chapter` (id, course_id, name) values ('00000013','00000000','测试大章13');
insert into `chapter` (id, course_id, name) values ('00000014','00000000','测试大章14');
insert into `chapter` (id, course_id, name) values ('00000015','00000000','测试大章15');
insert into `chapter` (id, course_id, name) values ('00000016','00000000','测试大章16');
insert into `chapter` (id, course_id, name) values ('00000017','00000000','测试大章17');
insert into `chapter` (id, course_id, name) values ('00000018','00000000','测试大章18');
insert into `chapter` (id, course_id, name) values ('00000019','00000000','测试大章19');
insert into `chapter` (id, course_id, name) values ('00000020','00000000','测试大章20');
insert into `chapter` (id, course_id, name) values ('00000021','00000000','测试大章21');
insert into `chapter` (id, course_id, name) values ('00000022','00000000','测试大章22');
insert into `chapter` (id, course_id, name) values ('00000023','00000000','测试大章23');
insert into `chapter` (id, course_id, name) values ('00000024','00000000','测试大章24');
insert into `chapter` (id, course_id, name) values ('00000025','00000000','测试大章25');
insert into `chapter` (id, course_id, name) values ('00000026','00000000','测试大章26');
insert into `chapter` (id, course_id, name) values ('00000027','00000000','测试大章27');

insert into `chapter` (id, course_id, name) values ('00000028','00000000','测试大章28');
insert into `chapter` (id, course_id, name) values ('00000029','00000000','测试大章29');
insert into `chapter` (id, course_id, name) values ('00000030','00000000','测试大章30');
insert into `chapter` (id, course_id, name) values ('00000031','00000000','测试大章31');
insert into `chapter` (id, course_id, name) values ('00000032','00000000','测试大章32');
insert into `chapter` (id, course_id, name) values ('00000033','00000000','测试大章33');
insert into `chapter` (id, course_id, name) values ('00000034','00000000','测试大章34');
insert into `chapter` (id, course_id, name) values ('00000035','00000000','测试大章35');
insert into `chapter` (id, course_id, name) values ('00000036','00000000','测试大章36');
insert into `chapter` (id, course_id, name) values ('00000037','00000000','测试大章37');
insert into `chapter` (id, course_id, name) values ('00000038','00000000','测试大章38');
insert into `chapter` (id, course_id, name) values ('00000039','00000000','测试大章39');
insert into `chapter` (id, course_id, name) values ('00000040','00000000','测试大章40');
insert into `chapter` (id, course_id, name) values ('00000041','00000000','测试大章41');
insert into `chapter` (id, course_id, name) values ('00000042','00000000','测试大章42');
insert into `chapter` (id, course_id, name) values ('00000043','00000000','测试大章43');
insert into `chapter` (id, course_id, name) values ('00000044','00000000','测试大章44');
insert into `chapter` (id, course_id, name) values ('00000045','00000000','测试大章45');
insert into `chapter` (id, course_id, name) values ('00000046','00000000','测试大章46');
insert into `chapter` (id, course_id, name) values ('00000047','00000000','测试大章47');
insert into `chapter` (id, course_id, name) values ('00000048','00000000','测试大章48');
insert into `chapter` (id, course_id, name) values ('00000049','00000000','测试大章49');
insert into `chapter` (id, course_id, name) values ('00000050','00000000','测试大章50');
insert into `chapter` (id, course_id, name) values ('00000051','00000000','测试大章51');
insert into `chapter` (id, course_id, name) values ('00000052','00000000','测试大章52');
insert into `chapter` (id, course_id, name) values ('00000053','00000000','测试大章53');
insert into `chapter` (id, course_id, name) values ('00000054','00000000','测试大章54');
# 小节
drop table if exists `section`;
create table `section`(
    `id` char(8) not null default '' comment 'id',
    `title` varchar(50) not null comment '标题',
    `course_id` char(8) comment '课程|course.id',
    `chapter_id` char(8) comment '大章|chapter_Id',
    `video` varchar(200) comment '视频',
    `time` int comment '时长|单位秒',
    `charge` char(1) comment '顺序',
    `sort` int comment '顺序',
    `created_at` datetime(3) comment '创建时间',
    `update_at` datetime(3) comment '修改时间',
    PRIMARY KEY (`id`)
)engine = innoDB default charset =UTF8mb4 comment '小节';
insert into `section` (id,title,course_id,chapter_id,video,time,charge,sort,created_at,update_at) values ('00000001','测试小节01','00000001','00000000','',500,'F',1,now(),now());

select * from chapter where course_id = 00000031 for update ;

drop table  if exists student ;
create table student(
    `id` char(8) not null default '' comment '学生标号',
    `name` varchar(50) not null  comment '学生姓名',
    `age` int(3) not null comment '年龄',
    primary key (`id`)
)engine = innodb default charset =utf8mb4 comment '学生表';

insert into student (id, name, age) VALUES ('0001','To1',11);
insert into student (id, name, age) VALUES ('0002','To2',11);
insert into student (id, name, age) VALUES ('0003','To3',11);
insert into student (id, name, age) VALUES ('0004','To4',11);
insert into student (id, name, age) VALUES ('0005','To5',11);
insert into student (id, name, age) VALUES ('0006','To6',11);
insert into student (id, name, age) VALUES ('0007','To7',11);
insert into student (id, name, age) VALUES ('0008','To8',11);
insert into student (id, name, age) VALUES ('0009','To9',11);
insert into student (id, name, age) VALUES ('00010','T10m',11);
insert into student (id, name, age) VALUES ('00011','T11m',11);
insert into student (id, name, age) VALUES ('00012','T12m',11);
insert into student (id, name, age) VALUES ('00013','T13m',11);
insert into student (id, name, age) VALUES ('00014','T14m',11);
insert into student (id, name, age) VALUES ('00015','T15m',11);
insert into student (id, name, age) VALUES ('00016','T16m',11);
insert into student (id, name, age) VALUES ('00017','T17m',11);
insert into student (id, name, age) VALUES ('00018','T18m',11);
insert into student (id, name, age) VALUES ('00019','T19m',11);
insert into student (id, name, age) VALUES ('00020','T20m',11);
insert into student (id, name, age) VALUES ('00021','T21m',11);
insert into student (id, name, age) VALUES ('00022','T22m',11);
insert into student (id, name, age) VALUES ('00023','T23m',11);
insert into student (id, name, age) VALUES ('00024','T24m',11);
insert into student (id, name, age) VALUES ('00025','T25m',11);
insert into student (id, name, age) VALUES ('00026','T26m',11);
insert into student (id, name, age) VALUES ('00027','T27m',11);
insert into student (id, name, age) VALUES ('00028','T28m',11);
insert into student (id, name, age) VALUES ('00029','T29m',11);
insert into student (id, name, age) VALUES ('00030','T30m',11);
insert into student (id, name, age) VALUES ('00031','T31m',11);
insert into student (id, name, age) VALUES ('00032','T32m',11);
insert into student (id, name, age) VALUES ('00033','T33m',11);
insert into student (id, name, age) VALUES ('00034','T34m',11);
insert into student (id, name, age) VALUES ('00035','T35m',11);
insert into student (id, name, age) VALUES ('00036','T36m',11);
insert into student (id, name, age) VALUES ('00037','T37m',11);
insert into student (id, name, age) VALUES ('00038','T38m',11);
insert into student (id, name, age) VALUES ('00039','T39m',11);
insert into student (id, name, age) VALUES ('00040','T40m',11);
insert into student (id, name, age) VALUES ('00041','T41m',11);
insert into student (id, name, age) VALUES ('00042','T42m',11);
insert into student (id, name, age) VALUES ('00043','T43m',11);
insert into student (id, name, age) VALUES ('00044','T44m',11);
insert into student (id, name, age) VALUES ('00045','T45m',11);
insert into student (id, name, age) VALUES ('00046','T46m',11);
insert into student (id, name, age) VALUES ('00047','T47m',11);
insert into student (id, name, age) VALUES ('00048','T48m',11);
insert into student (id, name, age) VALUES ('00049','T49m',11);
insert into student (id, name, age) VALUES ('00050','T50m',11);

create table `mall_catagory`(
    id int(11) NOT NULL AUTO_INCREMENT COMMENT '类别',
    `parent_id` int(11) Default Null COMMENT '父类别id当id=0时说明是根节点,一级类别',
    `name` varchar(50) DEFAULT null comment '类别名称',
    `status` tinyint(1) DEFAULT '1' comment '类别状态1-正常 2-已废弃',
    `sort_order` int(4) DEFAULT null Comment '排序编号,同类别展示顺序,数值相等则自然排序',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB AUTO_INCREMENT = 100031 DEFAULT CHARSET= UTF8;
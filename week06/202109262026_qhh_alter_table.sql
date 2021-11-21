ALTER TABLE `orders`
MODIFY COLUMN `create_time`  bigint(20) NULL DEFAULT NULL AFTER `money`,
MODIFY COLUMN `update_time`  bigint(20) NULL DEFAULT NULL AFTER `create_time`;

ALTER TABLE `consignee_address`
MODIFY COLUMN `consignee_telephone`  varchar(16) NULL DEFAULT NULL COMMENT '收件人电话' AFTER `consignee_name`;

ALTER TABLE `user`
MODIFY COLUMN `user_telephone`  varchar(16) NULL DEFAULT NULL COMMENT '手机号码' AFTER `identit_card`;

ALTER TABLE `commodity`
MODIFY COLUMN `create_time`  bigint(20) NULL DEFAULT NULL AFTER `commodity_label`,
MODIFY COLUMN `update_time`  bigint(20) NULL DEFAULT NULL AFTER `create_time`;


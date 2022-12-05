/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : ds_pc

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 05/12/2022 20:34:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `oder_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单id',
  `order_create_time` char(13) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建时间',
  `order_update_time` char(13) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改时间',
  `order_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单名称',
  `product_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单关联物品id',
  `user_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '下单人id',
  `shop_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '下单店铺id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for product_detail
-- ----------------------------
DROP TABLE IF EXISTS `product_detail`;
CREATE TABLE `product_detail`  (
  `product_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品ID',
  `product_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名称',
  `product_shop` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品店铺',
  `product_comment_count` int(7) DEFAULT NULL COMMENT '累计评论',
  `product_deal_count` int(7) DEFAULT NULL COMMENT '交易成功',
  `product_color` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品颜色',
  `product_for_gold` decimal(5, 2) DEFAULT NULL COMMENT '抵金币',
  `product_weight` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品重量',
  `product_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品类型',
  `product_repertory` int(6) DEFAULT NULL COMMENT '商品库存',
  `product_collect` int(5) DEFAULT NULL COMMENT '收藏',
  `product_freight` decimal(10, 2) DEFAULT NULL COMMENT '运费',
  `product_monthly_sale` int(6) DEFAULT NULL COMMENT '月销',
  `product_introduce` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品介绍',
  `product_particulars` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '富文本详情',
  `product_evaluate` double(3, 1) DEFAULT NULL COMMENT '评分',
  `product_label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品标签',
  `product_imgs` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片链接',
  `create_time` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建时间',
  `update_time` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_detail
-- ----------------------------
INSERT INTO `product_detail` VALUES ('pro16469161528251714', '润百颜润百颜娇韵润百颜润百颜雅诗兰黛人见人爱人见人爱好用连衣裙', '彭玉芳', 2411, 305, '白色', 0.22, '1g', '电子', 6536, 5601, 10.05, 707, 'abababababababababababababababababababababab', '--------', 2.0, '一般', '---------------', '1646916152825', '1646916152825');
INSERT INTO `product_detail` VALUES ('pro16469161531197914', '润百颜学生2022精华雅诗兰黛人见人爱2022润百颜娇韵手机', '郑意婷', 5408, 704, '白色', 3.99, '1.05g', '酒店', 1302, 4989, 10.05, 653, 'abababababababababababababababababababababab', '--------', 2.5, '差', '---------------', '1646916153119', '1646916153119');
INSERT INTO `product_detail` VALUES ('pro16469161532098380', '娇韵2022学生雅诗兰黛2022学生雅诗兰黛学生学生真丝连衣裙', '彭玉芳', 7043, 119, '綠色', 4.23, '1kg', '电子', 7317, 4402, 10.05, 807, 'abababababababababababababababababababababab', '--------', 3.5, '非常差', '---------------', '1646916153209', '1646916153209');
INSERT INTO `product_detail` VALUES ('pro164691615339285', '2022润百颜2022精华润百颜润百颜2022润百颜精华女装', '郑意婷', 9504, 435, '白色', 3.14, '100g', '书籍', 3512, 3829, 10.05, 753, 'abababababababababababababababababababababab', '--------', 2.5, '一般', '---------------', '1646916153392', '1646916153392');
INSERT INTO `product_detail` VALUES ('pro16469161536595459', '娇韵精华精华精华雅诗兰黛娇韵精华精华娇韵2022好用娇韵窗帘', '郑意婷', 6787, 792, '綠色', 7.69, '100g', '电子', 6796, 6310, 10.05, 689, 'abababababababababababababababababababababab', '--------', 3.5, '非常好', '---------------', '1646916153659', '1646916153659');
INSERT INTO `product_detail` VALUES ('pro16469161538598847', '人见人爱雅诗兰黛润百颜娇韵人见人爱人见人爱好用精华好用学生旗袍', '郑意婷', 3859, 653, '紅色', 7.10, '100g', '书籍', 9536, 9202, 10.05, 565, 'abababababababababababababababababababababab', '--------', 3.5, '非常好', '---------------', '1646916153859', '1646916153859');
INSERT INTO `product_detail` VALUES ('pro16469161539593568', '精华润百颜精华学生学生人见人爱好用2022润百颜精华好用沙发', '郑意婷', 3027, 211, '混合色', 9.27, '1kg', '美食', 3615, 4425, 10.05, 426, 'abababababababababababababababababababababab', '--------', 4.5, '一般', '---------------', '1646916153959', '1646916153959');
INSERT INTO `product_detail` VALUES ('pro1646916154133988', '精华学生润百颜精华学生人见人爱20222022润百颜蓝牙耳机', '彭玉芳', 7746, 920, '混合色', 4.44, '1g', '旅游', 4572, 2405, 10.05, 610, 'abababababababababababababababababababababab', '--------', 1.5, '差', '---------------', '1646916154133', '1646916154133');
INSERT INTO `product_detail` VALUES ('pro16469161542172162', '20222022娇韵学生2022雅诗兰黛好用润百颜雅诗兰黛空调', '郑意婷', 9569, 498, '黑色', 5.00, '2.5kg', '书籍', 1806, 2973, 10.05, 251, 'abababababababababababababababababababababab', '--------', 1.0, '一般', '---------------', '1646916154217', '1646916154217');
INSERT INTO `product_detail` VALUES ('pro16469161543741703', '人见人爱好用雅诗兰黛娇韵好用精华雅诗兰黛学生精华娇韵2022男鞋', '郑意婷', 901, 899, '綠色', 8.21, '100g', '书籍', 90, 9078, 10.05, 399, 'abababababababababababababababababababababab', '--------', 4.0, '好', '---------------', '1646916154374', '1646916154374');
INSERT INTO `product_detail` VALUES ('pro16469165390163745', '好用娇韵人见人爱人见人爱好用润百颜2022精华2022连衣裙', '郑意婷', 9337, 579, '混合色', 0.57, '', '厨房', 400, 5200, 10.05, 722, 'abababababababababababababababababababababab', '--------', 4.5, '差', '---------------', '1646916539016', '1646916539016');
INSERT INTO `product_detail` VALUES ('pro16469165393162524', '学生人见人爱雅诗兰黛精华人见人爱人见人爱娇韵好用人见人爱手机', '郑意婷', 2270, 684, '混合色', 4.72, '500g', '旅游', 9756, 2286, 10.05, 5, 'abababababababababababababababababababababab', '--------', 3.5, '很差', '---------------', '1646916539316', '1646916539316');
INSERT INTO `product_detail` VALUES ('pro16469165393735974', '润百颜润百颜学生润百颜学生2022精华雅诗兰黛学生真丝连衣裙', '郑意婷', 5376, 994, '綠色', 8.79, '1.05g', '书籍', 5251, 309, 10.05, 32, 'abababababababababababababababababababababab', '--------', 2.5, '很好', '---------------', '1646916539373', '1646916539373');
INSERT INTO `product_detail` VALUES ('pro16469165396998161', '润百颜润百颜2022娇韵雅诗兰黛人见人爱雅诗兰黛学生娇韵女装', '郑意婷', 2526, 829, '紅色', 3.87, '50Kg', '旅游', 3691, 6989, 10.05, 111, 'abababababababababababababababababababababab', '--------', 4.0, '一般', '---------------', '1646916539699', '1646916539699');
INSERT INTO `product_detail` VALUES ('pro16469165398654069', '雅诗兰黛精华娇韵润百颜2022娇韵学生学生好用精华2022窗帘', '郑意婷', 5848, 713, '紅色', 5.43, '100g', '旅游', 2837, 6771, 10.05, 263, 'abababababababababababababababababababababab', '--------', 4.5, '好', '---------------', '1646916539865', '1646916539865');
INSERT INTO `product_detail` VALUES ('pro16469165400824316', '2022人见人爱精华雅诗兰黛2022好用学生好用精华学生旗袍', '彭玉芳', 3261, 164, '紅色', 8.09, '100g', '旅游', 274, 8750, 10.05, 848, 'abababababababababababababababababababababab', '--------', 4.5, '好', '---------------', '1646916540082', '1646916540082');
INSERT INTO `product_detail` VALUES ('pro16469165401484574', '20222022润百颜娇韵精华人见人爱娇韵学生娇韵润百颜沙发', '彭玉芳', 4992, 341, '混合色', 3.20, '1000g', '书籍', 5126, 6396, 10.05, 542, 'abababababababababababababababababababababab', '--------', 3.5, '很差', '---------------', '1646916540148', '1646916540148');
INSERT INTO `product_detail` VALUES ('pro16469165402483972', '雅诗兰黛学生人见人爱润百颜精华2022学生润百颜好用润百颜蓝牙耳机', '彭玉芳', 730, 79, '綠色', 1.63, '1000g', '书籍', 656, 7451, 10.05, 784, 'abababababababababababababababababababababab', '--------', 3.5, '很差', '---------------', '1646916540248', '1646916540248');
INSERT INTO `product_detail` VALUES ('pro16469165404488156', '2022好用人见人爱人见人爱雅诗兰黛娇韵人见人爱好用精华润百颜空调', '郑意婷', 8233, 776, '綠色', 9.96, '500g', '书籍', 9584, 9993, 10.05, 220, 'abababababababababababababababababababababab', '--------', 2.0, '差', '---------------', '1646916540448', '1646916540448');
INSERT INTO `product_detail` VALUES ('pro16469165405999819', '好用雅诗兰黛雅诗兰黛娇韵润百颜人见人爱学生人见人爱人见人爱男鞋', '郑意婷', 4809, 500, '', 2.12, '', '美食', 6381, 3010, 10.05, 294, 'abababababababababababababababababababababab', '--------', 2.5, '非常好', '---------------', '1646916540599', '1646916540599');
INSERT INTO `product_detail` VALUES ('pro16469165406991868', '润百颜雅诗兰黛润百颜2022娇韵润百颜润百颜娇韵好用精华学生衣柜', '郑意婷', 7536, 191, '紅色', 2.66, '100g', '服装', 1012, 7703, 10.05, 995, 'abababababababababababababababababababababab', '--------', 3.0, '非常差', '---------------', '1646916540699', '1646916540699');
INSERT INTO `product_detail` VALUES ('pro16469165408748330', '雅诗兰黛雅诗兰黛学生精华学生雅诗兰黛精华学生润百颜真丝香云纱连衣裙', '郑意婷', 3329, 106, '', 4.57, '1g', '书籍', 771, 7961, 10.05, 336, 'abababababababababababababababababababababab', '--------', 3.5, '一般', '---------------', '1646916540874', '1646916540874');
INSERT INTO `product_detail` VALUES ('pro16469165409497302', '娇韵润百颜好用雅诗兰黛2022好用精华学生好用娇韵精华精华华为', '郑意婷', 5256, 910, '其他', 4.47, '1g', '服装', 1497, 3178, 10.05, 228, 'abababababababababababababababababababababab', '--------', 2.5, '非常好', '---------------', '1646916540949', '1646916540949');
INSERT INTO `product_detail` VALUES ('pro16469166645741267', '人见人爱学生人见人爱好用人见人爱精华人见人爱学生学生学生学生连衣裙', '郑意婷', 5001, 554, '紅色', 5.79, '500g', '酒店', 2616, 966, 10.05, 93, 'abababababababababababababababababababababab', '--------', 3.5, '非常好', '---------------', '1646916664574', '1646916664574');
INSERT INTO `product_detail` VALUES ('pro16469166650006558', '娇韵好用学生人见人爱人见人爱人见人爱2022人见人爱学生手机', '郑意婷', 8861, 184, '黑色', 3.36, '50Kg', '书籍', 4015, 7013, 10.05, 496, 'abababababababababababababababababababababab', '--------', 1.0, '很差', '---------------', '1646916665000', '1646916665000');
INSERT INTO `product_detail` VALUES ('pro16469166651418091', '精华好用好用人见人爱学生好用娇韵润百颜人见人爱好用真丝连衣裙', '彭玉芳', 7417, 492, '黑色', 3.05, '100g', '旅游', 2193, 289, 10.05, 921, 'abababababababababababababababababababababab', '--------', 1.5, '差', '---------------', '1646916665141', '1646916665141');
INSERT INTO `product_detail` VALUES ('pro16469166653663300', '2022润百颜精华20222022雅诗兰黛2022雅诗兰黛女装', '彭玉芳', 7422, 282, '綠色', 9.76, '100g', '美食', 7267, 2776, 10.05, 479, 'abababababababababababababababababababababab', '--------', 1.5, '非常差', '---------------', '1646916665366', '1646916665366');
INSERT INTO `product_detail` VALUES ('pro16469167423851699', '娇韵学生雅诗兰黛润百颜学生润百颜好用雅诗兰黛雅诗兰黛好用连衣裙', '郑意婷', 5558, 826, '混合色', 5.98, '50Kg', '美食', 498, 9026, 10.05, 172, 'abababababababababababababababababababababab', '--------', 3.5, '一般', '---------------', '1646916742385', '1646916742385');
INSERT INTO `product_detail` VALUES ('pro16469167427261902', '学生润百颜人见人爱雅诗兰黛好用2022好用好用学生人见人爱手机', '郑意婷', 4043, 615, '混合色', 6.20, '', '电子', 3216, 6289, 10.05, 180, 'abababababababababababababababababababababab', '--------', 1.5, '很好', '---------------', '1646916742726', '1646916742726');
INSERT INTO `product_detail` VALUES ('pro16469167428941775', '雅诗兰黛2022人见人爱2022娇韵人见人爱润百颜好用真丝连衣裙', '郑意婷', 5516, 821, '綠色', 7.94, '2.5kg', '旅游', 8441, 6794, 10.05, 584, 'abababababababababababababababababababababab', '--------', 3.0, '一般', '---------------', '1646916742894', '1646916742894');
INSERT INTO `product_detail` VALUES ('pro16469167429751782', '2022雅诗兰黛雅诗兰黛人见人爱雅诗兰黛2022润百颜娇韵女装', '郑意婷', 4882, 225, '其他', 5.92, '100g', '酒店', 1125, 5347, 10.05, 958, 'abababababababababababababababababababababab', '--------', 3.0, '非常差', '---------------', '1646916742975', '1646916742975');
INSERT INTO `product_detail` VALUES ('pro16469167431001902', '好用2022学生润百颜娇韵学生润百颜精华娇韵2022娇韵窗帘', '郑意婷', 5878, 240, '其他', 8.18, '100g', '服装', 3233, 5632, 10.05, 951, 'abababababababababababababababababababababab', '--------', 4.5, '好', '---------------', '1646916743100', '1646916743100');
INSERT INTO `product_detail` VALUES ('pro16469167432841391', '2022精华20222022润百颜润百颜精华雅诗兰黛润百颜旗袍', '彭玉芳', 5664, 427, '混合色', 4.81, '2.5kg', '美食', 2355, 5241, 10.05, 783, 'abababababababababababababababababababababab', '--------', 4.5, '好', '---------------', '1646916743284', '1646916743284');
INSERT INTO `product_detail` VALUES ('pro16469167435001907', '人见人爱娇韵雅诗兰黛娇韵2022雅诗兰黛润百颜好用人见人爱沙发', '彭玉芳', 1232, 254, '混合色', 6.73, '1kg', '酒店', 6763, 6813, 10.05, 30, 'abababababababababababababababababababababab', '--------', 3.5, '很差', '---------------', '1646916743500', '1646916743500');
INSERT INTO `product_detail` VALUES ('pro16469167436421753', '好用好用好用好用学生2022雅诗兰黛人见人爱好用好用蓝牙耳机', '彭玉芳', 1676, 930, '黑色', 3.25, '1000g', '酒店', 4116, 9868, 10.05, 759, 'abababababababababababababababababababababab', '--------', 1.5, '差', '---------------', '1646916743642', '1646916743642');
INSERT INTO `product_detail` VALUES ('pro16469167438251495', '雅诗兰黛学生润百颜娇韵娇韵人见人爱精华雅诗兰黛好用娇韵精华空调', '彭玉芳', 5626, 774, '紅色', 9.96, '500g', '书籍', 418, 4694, 10.05, 968, 'abababababababababababababababababababababab', '--------', 2.5, '非常差', '---------------', '1646916743825', '1646916743825');
INSERT INTO `product_detail` VALUES ('pro16469167440341551', '人见人爱精华润百颜学生人见人爱娇韵娇韵娇韵精华学生人见人爱男鞋', '郑意婷', 8762, 106, '其他', 2.35, '1g', '酒店', 6831, 4028, 10.05, 610, 'abababababababababababababababababababababab', '--------', 3.0, '非常差', '---------------', '1646916744034', '1646916744034');
INSERT INTO `product_detail` VALUES ('pro16469167441421104', '娇韵娇韵人见人爱好用好用雅诗兰黛雅诗兰黛雅诗兰黛人见人爱衣柜', '郑意婷', 509, 842, '紅色', 3.96, '100g', '书籍', 250, 1707, 10.05, 12, 'abababababababababababababababababababababab', '--------', 4.0, '非常好', '---------------', '1646916744142', '1646916744142');
INSERT INTO `product_detail` VALUES ('pro16469167442501855', '学生学生人见人爱娇韵精华2022娇韵好用润百颜真丝香云纱连衣裙', '彭玉芳', 4463, 654, '混合色', 4.40, '100g', '酒店', 8722, 8315, 10.05, 749, 'abababababababababababababababababababababab', '--------', 3.0, '好', '---------------', '1646916744250', '1646916744250');
INSERT INTO `product_detail` VALUES ('pro16469167447091900', '精华雅诗兰黛精华好用人见人爱精华雅诗兰黛好用娇韵好用润百颜华为', '彭玉芳', 7383, 754, '綠色', 0.80, '500g', '旅游', 8700, 2051, 10.05, 954, 'abababababababababababababababababababababab', '--------', 1.0, '非常差', '---------------', '1646916744709', '1646916744709');
INSERT INTO `product_detail` VALUES ('pro16469167448751224', '雅诗兰黛2022润百颜2022学生雅诗兰黛人见人爱好用半身裙', '郑意婷', 9953, 842, '綠色', 1.04, '100g', '酒店', 6489, 703, 10.05, 482, 'abababababababababababababababababababababab', '--------', 2.5, '很好', '---------------', '1646916744875', '1646916744875');
INSERT INTO `product_detail` VALUES ('pro16469167450501915', '娇韵好用精华人见人爱学生润百颜润百颜学生2022学生大码女装', '郑意婷', 2010, 84, '其他', 1.53, '2.5kg', '服装', 5882, 9386, 10.05, 997, 'abababababababababababababababababababababab', '--------', 2.5, '好', '---------------', '1646916745050', '1646916745050');
INSERT INTO `product_detail` VALUES ('pro16469167452501980', '人见人爱精华精华娇韵2022好用润百颜润百颜润百颜润百颜鱼竿', '郑意婷', 8319, 945, '紅色', 0.66, '100g', '书籍', 3701, 607, 10.05, 253, 'abababababababababababababababababababababab', '--------', 1.5, '很差', '---------------', '1646916745250', '1646916745250');
INSERT INTO `product_detail` VALUES ('pro16469167453171702', '2022好用好用2022人见人爱精华好用精华2022好用学生拉杆箱', '彭玉芳', 9897, 874, '紅色', 9.80, '1g', '服装', 5769, 9480, 10.05, 764, 'abababababababababababababababababababababab', '--------', 4.0, '差', '---------------', '1646916745317', '1646916745317');
INSERT INTO `product_detail` VALUES ('pro16469167454251437', '人见人爱学生润百颜2022润百颜润百颜润百颜2022荣耀9x', '郑意婷', 4036, 539, '黑色', 1.60, '1000g', '美食', 9710, 8245, 10.05, 231, 'abababababababababababababababababababababab', '--------', 2.5, '很好', '---------------', '1646916745425', '1646916745425');
INSERT INTO `product_detail` VALUES ('pro16469167456431556', '2022学生润百颜润百颜2022润百颜精华雅诗兰黛学生雅诗兰黛t恤', '彭玉芳', 1418, 816, '其他', 9.58, '1kg', '服装', 8020, 352, 10.05, 80, 'abababababababababababababababababababababab', '--------', 4.0, '很差', '---------------', '1646916745643', '1646916745643');
INSERT INTO `product_detail` VALUES ('pro16469167458441832', '娇韵精华精华学生精华精华好用精华娇韵20222022行车记录仪', '彭玉芳', 9626, 771, '黑色', 1.34, '2.5kg', '美食', 352, 3807, 10.05, 396, 'abababababababababababababababababababababab', '--------', 2.0, '非常好', '---------------', '1646916745844', '1646916745844');

-- ----------------------------
-- Table structure for product_price
-- ----------------------------
DROP TABLE IF EXISTS `product_price`;
CREATE TABLE `product_price`  (
  `product_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品ID',
  `price` decimal(10, 2) DEFAULT NULL COMMENT '价格',
  `tb_price` decimal(10, 2) DEFAULT NULL COMMENT '淘宝价格',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '图片',
  `content` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '描述'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product_price
-- ----------------------------
INSERT INTO `product_price` VALUES ('pro16469161528251714', 103.27, 82.61, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469161528251714', 31.84, 25.47, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469161528251714', 438.79, 351.03, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469161531197914', 862.74, 690.19, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469161531197914', 639.18, 511.35, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469161532098380', 937.42, 749.94, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469161532098380', 824.32, 659.46, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469161532098380', 869.00, 695.20, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469161532098380', 214.37, 171.50, '图片3', '类型3');
INSERT INTO `product_price` VALUES ('pro164691615339285', 587.22, 469.77, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro164691615339285', 131.17, 104.94, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro164691615339285', 720.85, 576.68, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro164691615339285', 153.93, 123.14, '图片3', '类型3');
INSERT INTO `product_price` VALUES ('pro164691615339285', 106.31, 85.05, '图片4', '类型4');
INSERT INTO `product_price` VALUES ('pro16469161536595459', 604.30, 483.44, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469161536595459', 756.21, 604.97, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469161536595459', 391.15, 312.92, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469161536595459', 243.19, 194.56, '图片3', '类型3');
INSERT INTO `product_price` VALUES ('pro16469161536595459', 471.74, 377.39, '图片4', '类型4');
INSERT INTO `product_price` VALUES ('pro16469161538598847', 46.75, 37.40, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469161538598847', 875.86, 700.69, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469161539593568', 170.18, 136.15, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469161539593568', 873.62, 698.89, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469161539593568', 903.24, 722.59, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469161539593568', 767.60, 614.08, '图片3', '类型3');
INSERT INTO `product_price` VALUES ('pro16469161539593568', 580.18, 464.15, '图片4', '类型4');
INSERT INTO `product_price` VALUES ('pro1646916154133988', 474.38, 379.50, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469161542172162', 718.58, 574.86, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469161542172162', 606.37, 485.10, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469161543741703', 78.01, 62.41, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469161543741703', 888.83, 711.07, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469161543741703', 115.36, 92.29, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469165390163745', 891.20, 712.96, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469165390163745', 609.52, 487.62, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469165390163745', 739.25, 591.40, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469165393162524', 195.00, 156.00, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469165393735974', 496.19, 396.96, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469165393735974', 175.99, 140.79, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469165393735974', 432.08, 345.67, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469165396998161', 219.26, 175.41, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469165396998161', 690.41, 552.33, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469165398654069', 543.94, 435.16, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469165398654069', 948.39, 758.71, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469165398654069', 894.93, 715.95, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469165398654069', 738.85, 591.08, '图片3', '类型3');
INSERT INTO `product_price` VALUES ('pro16469165400824316', 825.28, 660.23, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469165401484574', 660.02, 528.02, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469165401484574', 934.31, 747.45, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469165402483972', 13.84, 11.07, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469165402483972', 370.90, 296.72, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469165402483972', 490.81, 392.65, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469165402483972', 198.63, 158.90, '图片3', '类型3');
INSERT INTO `product_price` VALUES ('pro16469165402483972', 758.49, 606.79, '图片4', '类型4');
INSERT INTO `product_price` VALUES ('pro16469165404488156', 195.50, 156.40, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469165404488156', 485.34, 388.27, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469165404488156', 999.87, 799.89, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469165404488156', 642.71, 514.17, '图片3', '类型3');
INSERT INTO `product_price` VALUES ('pro16469165405999819', 181.97, 145.58, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469165405999819', 512.44, 409.96, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469165406991868', 202.55, 162.04, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469165408748330', 687.04, 549.63, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469165409497302', 673.79, 539.03, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469165409497302', 754.77, 603.82, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469165409497302', 483.99, 387.19, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469165409497302', 585.91, 468.73, '图片3', '类型3');
INSERT INTO `product_price` VALUES ('pro16469165409497302', 194.23, 155.38, '图片4', '类型4');
INSERT INTO `product_price` VALUES ('pro16469166645741267', 331.98, 265.58, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469166645741267', 526.57, 421.26, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469166645741267', 80.48, 64.38, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469166650006558', 975.62, 780.50, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469166650006558', 565.52, 452.42, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469166650006558', 550.49, 440.39, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469166651418091', 510.09, 408.07, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469166651418091', 562.50, 450.00, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469166651418091', 816.73, 653.39, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469166651418091', 437.11, 349.69, '图片3', '类型3');
INSERT INTO `product_price` VALUES ('pro16469166653663300', 856.15, 684.92, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469166653663300', 738.96, 591.17, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469166653663300', 91.88, 73.50, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469167423851699', 595.51, 476.41, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469167423851699', 274.48, 219.58, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469167423851699', 176.12, 140.90, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469167423851699', 705.51, 564.41, '图片3', '类型3');
INSERT INTO `product_price` VALUES ('pro16469167423851699', 475.33, 380.27, '图片4', '类型4');
INSERT INTO `product_price` VALUES ('pro16469167427261902', 8.99, 7.20, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469167428941775', 74.52, 59.61, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469167428941775', 238.76, 191.01, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469167429751782', 727.21, 581.76, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469167429751782', 788.21, 630.57, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469167429751782', 837.97, 670.38, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469167431001902', 968.07, 774.45, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469167431001902', 364.41, 291.53, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469167431001902', 894.42, 715.54, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469167432841391', 665.81, 532.65, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469167432841391', 350.95, 280.76, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469167432841391', 103.85, 83.08, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469167432841391', 556.61, 445.28, '图片3', '类型3');
INSERT INTO `product_price` VALUES ('pro16469167435001907', 903.54, 722.83, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469167435001907', 243.75, 195.00, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469167435001907', 149.87, 119.90, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469167436421753', 203.49, 162.79, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469167436421753', 566.17, 452.93, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469167436421753', 327.42, 261.93, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469167436421753', 540.58, 432.46, '图片3', '类型3');
INSERT INTO `product_price` VALUES ('pro16469167436421753', 438.30, 350.64, '图片4', '类型4');
INSERT INTO `product_price` VALUES ('pro16469167438251495', 796.92, 637.54, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469167438251495', 170.20, 136.16, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469167438251495', 398.33, 318.66, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469167438251495', 390.20, 312.16, '图片3', '类型3');
INSERT INTO `product_price` VALUES ('pro16469167440341551', 319.83, 255.86, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469167440341551', 607.70, 486.16, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469167441421104', 990.04, 792.03, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469167441421104', 225.49, 180.39, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469167442501855', 823.27, 658.62, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469167442501855', 212.77, 170.21, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469167442501855', 567.80, 454.24, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469167442501855', 339.72, 271.77, '图片3', '类型3');
INSERT INTO `product_price` VALUES ('pro16469167442501855', 196.37, 157.10, '图片4', '类型4');
INSERT INTO `product_price` VALUES ('pro16469167447091900', 856.89, 685.51, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469167447091900', 75.39, 60.31, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469167448751224', 622.55, 498.04, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469167448751224', 141.67, 113.33, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469167448751224', 177.28, 141.83, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469167448751224', 784.39, 627.51, '图片3', '类型3');
INSERT INTO `product_price` VALUES ('pro16469167450501915', 763.41, 610.73, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469167450501915', 991.21, 792.97, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469167450501915', 324.97, 259.98, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469167452501980', 645.28, 516.22, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469167453171702', 989.90, 791.92, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469167453171702', 266.28, 213.02, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469167454251437', 460.36, 368.28, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469167454251437', 411.35, 329.08, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469167454251437', 211.59, 169.27, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469167454251437', 635.41, 508.33, '图片3', '类型3');
INSERT INTO `product_price` VALUES ('pro16469167454251437', 552.77, 442.21, '图片4', '类型4');
INSERT INTO `product_price` VALUES ('pro16469167456431556', 522.54, 418.03, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469167456431556', 565.52, 452.41, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469167456431556', 391.98, 313.59, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469167456431556', 203.49, 162.79, '图片3', '类型3');
INSERT INTO `product_price` VALUES ('pro16469167456431556', 122.60, 98.08, '图片4', '类型4');
INSERT INTO `product_price` VALUES ('pro16469167458441832', 684.99, 547.99, '图片0', '类型0');
INSERT INTO `product_price` VALUES ('pro16469167458441832', 384.06, 307.25, '图片1', '类型1');
INSERT INTO `product_price` VALUES ('pro16469167458441832', 714.34, 571.47, '图片2', '类型2');
INSERT INTO `product_price` VALUES ('pro16469167458441832', 305.45, 244.36, '图片3', '类型3');
INSERT INTO `product_price` VALUES ('pro16469167458441832', 285.95, 228.76, '图片4', '类型4');

-- ----------------------------
-- Table structure for shop_store
-- ----------------------------
DROP TABLE IF EXISTS `shop_store`;
CREATE TABLE `shop_store`  (
  `shop_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '店铺id',
  `user_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '店铺人员id',
  `shop_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '店铺类型',
  `shop_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '店铺名称',
  `create_time` char(13) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建时间',
  `update_time` char(13) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '修改时间',
  `shop_status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '店铺状态：0关闭,1封停，2正常',
  PRIMARY KEY (`shop_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop_store
-- ----------------------------
INSERT INTO `shop_store` VALUES ('sho1669035120531jzCE', 'use16481231302651117', '个人', '111', '1669035120530', '1669035120530', '2');

-- ----------------------------
-- Table structure for user_detail
-- ----------------------------
DROP TABLE IF EXISTS `user_detail`;
CREATE TABLE `user_detail`  (
  `user_id` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `identity_card` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证 ',
  `native_place` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '籍贯',
  `tag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '标签',
  `like` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '爱好',
  `contact_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '联系地址',
  `signature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '签名',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_login
-- ----------------------------
DROP TABLE IF EXISTS `user_login`;
CREATE TABLE `user_login`  (
  `user_id` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名称',
  `user_account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户账户',
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '手机',
  `registration_time` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_login
-- ----------------------------
INSERT INTO `user_login` VALUES ('use16481231300031031', '孙香', 'admin0', '11110', '11@11.com', '18218548497', '1648123130003');
INSERT INTO `user_login` VALUES ('use16481231302651117', '郑风冬', 'admin1', '1111144444', '11@11.com', '18218548496', '1648123130265');
INSERT INTO `user_login` VALUES ('use16481231302971169', '欧阳聂', 'admin2', '11112', '11@11.com', '1872', '1648123130297');
INSERT INTO `user_login` VALUES ('use16481231303211489', '吴艳', 'admin3', '11113', '11@11.com', '1873', '1648123130321');
INSERT INTO `user_login` VALUES ('use16481231303501960', '孙洁', 'admin4', '11114', '11@11.com', '1874', '1648123130350');
INSERT INTO `user_login` VALUES ('use16481231303801751', '彭西意', 'admin5', '11115', '11@11.com', '1875', '1648123130380');
INSERT INTO `user_login` VALUES ('use16481231304131355', '卫世秋', 'admin6', '11116', '11@11.com', '1876', '1648123130413');
INSERT INTO `user_login` VALUES ('use16481231304391196', '冯龙', 'admin7', '11117', '11@11.com', '1877', '1648123130439');
INSERT INTO `user_login` VALUES ('use16481231304791493', '刘玉燕', 'admin8', '11118', '11@11.com', '1878', '1648123130479');
INSERT INTO `user_login` VALUES ('use16481231305051569', '龙燕', 'admin9', '11119', '11@11.com', '1879', '1648123130505');
INSERT INTO `user_login` VALUES ('use16481231305421806', '司马铠', 'admin10', '111110', '11@11.com', '18710', '1648123130542');
INSERT INTO `user_login` VALUES ('use16481231305711963', '郑庄', 'admin11', '111111', '11@11.com', '18711', '1648123130571');
INSERT INTO `user_login` VALUES ('use16481231305961061', '孙晓南', 'admin12', '111112', '11@11.com', '18712', '1648123130596');
INSERT INTO `user_login` VALUES ('use16481231306221931', '邓平', 'admin13', '111113', '11@11.com', '18713', '1648123130622');
INSERT INTO `user_login` VALUES ('use16481231306461831', '孙艳', 'admin14', '111114', '11@11.com', '18714', '1648123130646');
INSERT INTO `user_login` VALUES ('use16481231306711878', '褚冬春', 'admin15', '111115', '11@11.com', '18715', '1648123130671');
INSERT INTO `user_login` VALUES ('use16481231307001238', '罗小纯', 'admin16', '111116', '11@11.com', '18716', '1648123130700');
INSERT INTO `user_login` VALUES ('use16481231307301430', '李铠', 'admin17', '111117', '11@11.com', '18717', '1648123130730');
INSERT INTO `user_login` VALUES ('use16481231308131257', '李洁', 'admin18', '111118', '11@11.com', '18718', '1648123130813');
INSERT INTO `user_login` VALUES ('use16481231308381608', '褚婷', 'admin19', '111119', '11@11.com', '18719', '1648123130838');
INSERT INTO `user_login` VALUES ('use16481231308631173', '欧阳可', 'admin20', '111120', '11@11.com', '18720', '1648123130863');
INSERT INTO `user_login` VALUES ('use16481231308891614', '许天昊', 'admin21', '111121', '11@11.com', '18721', '1648123130889');
INSERT INTO `user_login` VALUES ('use16481231309251129', '诸葛科纯', 'admin22', '111122', '11@11.com', '18722', '1648123130925');
INSERT INTO `user_login` VALUES ('use16481231309551862', '罗艳', 'admin23', '111123', '11@11.com', '18723', '1648123130955');
INSERT INTO `user_login` VALUES ('use16481231309971165', '张香', 'admin24', '111124', '11@11.com', '18724', '1648123130997');
INSERT INTO `user_login` VALUES ('use16481231310801918', '北丘燕春', 'admin25', '111125', '11@11.com', '18725', '1648123131080');
INSERT INTO `user_login` VALUES ('use16481231311461235', '邱秋昊', 'admin26', '111126', '11@11.com', '18726', '1648123131146');
INSERT INTO `user_login` VALUES ('use16481231311821373', '李龙', 'admin27', '111127', '11@11.com', '18727', '1648123131182');
INSERT INTO `user_login` VALUES ('use16481231312131800', '冯杰', 'admin28', '111128', '11@11.com', '18728', '1648123131213');
INSERT INTO `user_login` VALUES ('use16481231312631430', '孙南夏', 'admin29', '111129', '11@11.com', '18729', '1648123131263');
INSERT INTO `user_login` VALUES ('use16481231313051436', '郑皓春', 'admin30', '111130', '11@11.com', '18730', '1648123131305');
INSERT INTO `user_login` VALUES ('use16481231313721345', '邱洁', 'admin31', '111131', '11@11.com', '18731', '1648123131372');
INSERT INTO `user_login` VALUES ('use16481231314081243', '南宫龙', 'admin32', '111132', '11@11.com', '18732', '1648123131408');
INSERT INTO `user_login` VALUES ('use16481231314551964', '王平', 'admin33', '111133', '11@11.com', '18733', '1648123131455');
INSERT INTO `user_login` VALUES ('use16481231314971533', '陈芳', 'admin34', '111134', '11@11.com', '18734', '1648123131497');
INSERT INTO `user_login` VALUES ('use16481231315551893', '褚芳', 'admin35', '111135', '11@11.com', '18735', '1648123131555');
INSERT INTO `user_login` VALUES ('use16481231315961054', '周庄', 'admin36', '111136', '11@11.com', '18736', '1648123131596');
INSERT INTO `user_login` VALUES ('use16481231316331471', '吴可', 'admin37', '111137', '11@11.com', '18737', '1648123131633');
INSERT INTO `user_login` VALUES ('use16481231316631436', '邓洁', 'admin38', '111138', '11@11.com', '18738', '1648123131663');
INSERT INTO `user_login` VALUES ('use16481231316961115', '赵西天', 'admin39', '111139', '11@11.com', '18739', '1648123131696');
INSERT INTO `user_login` VALUES ('use16481231317211064', '卫秋天', 'admin40', '111140', '11@11.com', '18740', '1648123131721');
INSERT INTO `user_login` VALUES ('use16481231317461959', '司马木冬', 'admin41', '111141', '11@11.com', '18741', '1648123131746');
INSERT INTO `user_login` VALUES ('use16481231318361563', '刘香', 'admin42', '111142', '11@11.com', '18742', '1648123131836');
INSERT INTO `user_login` VALUES ('use16481231319341484', '吴洁', 'admin43', '111143', '11@11.com', '18743', '1648123131934');
INSERT INTO `user_login` VALUES ('use16481231319921114', '龙燕', 'admin44', '111144', '11@11.com', '18744', '1648123131992');
INSERT INTO `user_login` VALUES ('use16481231320571546', '邱聂', 'admin45', '111145', '11@11.com', '18745', '1648123132057');
INSERT INTO `user_login` VALUES ('use16481231321591530', '陈林皓', 'admin46', '111146', '11@11.com', '18746', '1648123132160');
INSERT INTO `user_login` VALUES ('use16481231322001624', '西门燕', 'admin47', '111147', '11@11.com', '18747', '1648123132200');
INSERT INTO `user_login` VALUES ('use16481231322651791', '李秋晓', 'admin48', '111148', '11@11.com', '18748', '1648123132265');
INSERT INTO `user_login` VALUES ('use16481231323081986', '陈林小', 'admin49', '111149', '11@11.com', '18749', '1648123132308');
INSERT INTO `user_login` VALUES ('use16481231324051324', '钱山晓', 'admin50', '111150', '11@11.com', '18750', '1648123132405');
INSERT INTO `user_login` VALUES ('use16481231324291422', '卢傲', 'admin51', '111151', '11@11.com', '18751', '1648123132429');
INSERT INTO `user_login` VALUES ('use16481231324541546', '东方芳', 'admin52', '111152', '11@11.com', '18752', '1648123132454');
INSERT INTO `user_login` VALUES ('use16481231324841018', '罗香', 'admin53', '111153', '11@11.com', '18753', '1648123132484');
INSERT INTO `user_login` VALUES ('use16481231325131294', '南宫木小', 'admin54', '111154', '11@11.com', '18754', '1648123132513');
INSERT INTO `user_login` VALUES ('use16481231325381172', '钱聂', 'admin55', '111155', '11@11.com', '18755', '1648123132538');
INSERT INTO `user_login` VALUES ('use16481231325631853', '诸葛香', 'admin56', '111156', '11@11.com', '18756', '1648123132563');
INSERT INTO `user_login` VALUES ('use16481231325881111', '欧阳秋夏', 'admin57', '111157', '11@11.com', '18757', '1648123132588');
INSERT INTO `user_login` VALUES ('use16481231326171055', '刘可', 'admin58', '111158', '11@11.com', '18758', '1648123132617');
INSERT INTO `user_login` VALUES ('use16481231326461436', '卫天小', 'admin59', '111159', '11@11.com', '18759', '1648123132646');
INSERT INTO `user_login` VALUES ('use16481231326711382', '彭傲', 'admin60', '111160', '11@11.com', '18760', '1648123132671');
INSERT INTO `user_login` VALUES ('use16481231326961164', '邱可', 'admin61', '111161', '11@11.com', '18761', '1648123132696');
INSERT INTO `user_login` VALUES ('use16481231327211677', '诸葛木纯', 'admin62', '111162', '11@11.com', '18762', '1648123132721');
INSERT INTO `user_login` VALUES ('use16481231327461098', '郑龙', 'admin63', '111163', '11@11.com', '18763', '1648123132746');
INSERT INTO `user_login` VALUES ('use16481231327831485', '钱林南', 'admin64', '111164', '11@11.com', '18764', '1648123132783');
INSERT INTO `user_login` VALUES ('use16481231328131223', '西门铠', 'admin65', '111165', '11@11.com', '18765', '1648123132813');
INSERT INTO `user_login` VALUES ('use16481231328891686', '西门龙', 'admin66', '111166', '11@11.com', '18766', '1648123132889');
INSERT INTO `user_login` VALUES ('use16481231329211403', '吴晓玉', 'admin67', '111167', '11@11.com', '18767', '1648123132921');
INSERT INTO `user_login` VALUES ('use16481231329461968', '刘香', 'admin68', '111168', '11@11.com', '18768', '1648123132946');
INSERT INTO `user_login` VALUES ('use16481231329711308', '东方庄', 'admin69', '111169', '11@11.com', '18769', '1648123132971');
INSERT INTO `user_login` VALUES ('use16481231330001271', '邓可', 'admin70', '111170', '11@11.com', '18770', '1648123133000');
INSERT INTO `user_login` VALUES ('use16481231330641508', '卫春皓', 'admin71', '111171', '11@11.com', '18771', '1648123133064');
INSERT INTO `user_login` VALUES ('use16481231330961759', '郑木纯', 'admin72', '111172', '11@11.com', '18772', '1648123133096');
INSERT INTO `user_login` VALUES ('use16481231331211057', '王庄', 'admin73', '111173', '11@11.com', '18773', '1648123133121');
INSERT INTO `user_login` VALUES ('use16481231331581942', '诸葛龙', 'admin74', '111174', '11@11.com', '18774', '1648123133158');
INSERT INTO `user_login` VALUES ('use16481231331961542', '刘山秋', 'admin75', '111175', '11@11.com', '18775', '1648123133196');
INSERT INTO `user_login` VALUES ('use16481231332211219', '褚风玉', 'admin76', '111176', '11@11.com', '18776', '1648123133221');
INSERT INTO `user_login` VALUES ('use16481231332461208', '郑晓世', 'admin77', '111177', '11@11.com', '18777', '1648123133246');
INSERT INTO `user_login` VALUES ('use16481231332711798', '郑傲', 'admin78', '111178', '11@11.com', '18778', '1648123133271');
INSERT INTO `user_login` VALUES ('use16481231332961185', '李香', 'admin79', '111179', '11@11.com', '18779', '1648123133296');
INSERT INTO `user_login` VALUES ('use16481231333261182', '赵可', 'admin80', '111180', '11@11.com', '18780', '1648123133326');
INSERT INTO `user_login` VALUES ('use16481231333551788', '西门纯南', 'admin81', '111181', '11@11.com', '18781', '1648123133355');
INSERT INTO `user_login` VALUES ('use16481231333801321', '陈燕', 'admin82', '111182', '11@11.com', '18782', '1648123133380');
INSERT INTO `user_login` VALUES ('use16481231334051892', '冯皓纯', 'admin83', '111183', '11@11.com', '18783', '1648123133405');
INSERT INTO `user_login` VALUES ('use16481231334301298', '司马龙', 'admin84', '111184', '11@11.com', '18784', '1648123133430');
INSERT INTO `user_login` VALUES ('use16481231334551385', '冯皓天', 'admin85', '111185', '11@11.com', '18785', '1648123133455');
INSERT INTO `user_login` VALUES ('use16481231334831325', '北丘可', 'admin86', '111186', '11@11.com', '18786', '1648123133483');
INSERT INTO `user_login` VALUES ('use16481231335131841', '孙燕', 'admin87', '111187', '11@11.com', '18787', '1648123133514');
INSERT INTO `user_login` VALUES ('use16481231335381191', '南宫艳', 'admin88', '111188', '11@11.com', '18788', '1648123133538');
INSERT INTO `user_login` VALUES ('use16481231335631974', '褚杰', 'admin89', '111189', '11@11.com', '18789', '1648123133563');
INSERT INTO `user_login` VALUES ('use16481231335881737', '郑芳', 'admin90', '111190', '11@11.com', '18790', '1648123133588');
INSERT INTO `user_login` VALUES ('use16481231336671176', '刘春玉', 'admin91', '111191', '11@11.com', '18791', '1648123133667');
INSERT INTO `user_login` VALUES ('use16481231336961527', '周庄', 'admin92', '111192', '11@11.com', '18792', '1648123133696');
INSERT INTO `user_login` VALUES ('use16481231337211375', '北丘聂', 'admin93', '111193', '11@11.com', '18793', '1648123133721');
INSERT INTO `user_login` VALUES ('use16481231337461146', '孙婷', 'admin94', '111194', '11@11.com', '18794', '1648123133746');
INSERT INTO `user_login` VALUES ('use16481231337711984', '陈昊昊', 'admin95', '111195', '11@11.com', '18795', '1648123133771');
INSERT INTO `user_login` VALUES ('use16481231338211056', '北丘可', 'admin96', '111196', '11@11.com', '18796', '1648123133821');
INSERT INTO `user_login` VALUES ('use16481231338501669', '钱芳', 'admin97', '111197', '11@11.com', '18797', '1648123133850');
INSERT INTO `user_login` VALUES ('use16481231338801634', '王庄', 'admin98', '111198', '11@11.com', '18798', '1648123133880');
INSERT INTO `user_login` VALUES ('use16481231339051752', '陈天皓', 'admin99', '111199', '11@11.com', '18799', '1648123133905');
INSERT INTO `user_login` VALUES ('use16529594403361606', NULL, NULL, NULL, NULL, '18218548498', NULL);
INSERT INTO `user_login` VALUES ('use16529608356171116', NULL, NULL, NULL, NULL, '18218548499', NULL);
INSERT INTO `user_login` VALUES ('use16529609893741486', NULL, NULL, NULL, NULL, '18218548495', NULL);
INSERT INTO `user_login` VALUES ('use16529610348191982', NULL, NULL, NULL, NULL, '18218548491', NULL);
INSERT INTO `user_login` VALUES ('use16529612481691781', NULL, NULL, NULL, NULL, '18218548488', NULL);
INSERT INTO `user_login` VALUES ('use16529613310521207', NULL, NULL, NULL, NULL, '18218548598', NULL);
INSERT INTO `user_login` VALUES ('use16529613607971627', NULL, NULL, NULL, NULL, '18218548599', NULL);
INSERT INTO `user_login` VALUES ('use16529614462731714', NULL, NULL, NULL, NULL, '18218548577', NULL);
INSERT INTO `user_login` VALUES ('use16529615217801110', NULL, NULL, NULL, NULL, '18218548569', NULL);
INSERT INTO `user_login` VALUES ('use16529615779991997', NULL, NULL, NULL, NULL, '18218548547', NULL);
INSERT INTO `user_login` VALUES ('use16529619222021805', NULL, NULL, NULL, NULL, '18218548587', NULL);
INSERT INTO `user_login` VALUES ('use16529620373981603', NULL, NULL, NULL, NULL, '18218548555', NULL);
INSERT INTO `user_login` VALUES ('use1668425135967Hyzc', NULL, NULL, NULL, NULL, '15218548599', NULL);

SET FOREIGN_KEY_CHECKS = 1;

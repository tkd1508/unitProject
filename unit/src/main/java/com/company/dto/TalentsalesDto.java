package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TalentsalesDto {

// 판매글 등록 자식 테이블
private int salesNum; // PK
private String salesTitle;//
private String salesInfo;//
private String salesCurriculum;//
private int salesPrice;//
private String salesImg;//
private String salesMainCategory;//
private String salesSubCategory;//
private String salesRegistState;
private String salesDealState;
private String salesJoinDate;
private String salesJoinIp;//
//jsp 파일에서 session 받아야하는 정보
private int userNum; // FK

}

//| salesNum          | int(11)       | NO   | PRI | NULL              | auto_increment |
//| salesTitle        | varchar(255)  | NO   |     | NULL              |                |
//| salesInfo         | varchar(1000) | NO   |     | NULL              |                |
//| salesCurriculum   | varchar(1000) | NO   |     | NULL              |                |
//| salesPrice        | int(11)       | NO   |     | 0                 |                |
//| salesMainCategory | varchar(255)  | NO   |     | NULL              |                |
//| salesSubCategory  | varchar(255)  | NO   |     | NULL              |                |
//| salesImg          | varchar(1000) | NO   |     | NULL              |                |
//| salesRegistState  | varchar(50)   | YES  |     | 심사대기          |                |
//| salesDealState    | varchar(50)   | YES  |     | 거래전            |                |
//| salesJoinDate     | timestamp     | YES  |     | CURRENT_TIMESTAMP |                |
//| salesJoinIp       | varchar(255)  | NO   |     | NULL              |                |
//| userNum
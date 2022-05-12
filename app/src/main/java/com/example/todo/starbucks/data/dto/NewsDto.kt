package com.example.todo.starbucks.data.dto


import com.squareup.moshi.Json

data class NewsDto(
    @Json(name = "cnt")
    val cnt: Int,
    @Json(name = "list")
    val news: List<NewDto>,
    @Json(name = "vo")
    val vo: Vo,
)

data class NewDto(
    @Json(name = "active_QUATER")
    val activeQUATER: String?,
    @Json(name = "active_YEAR")
    val activeYEAR: String?,
    @Json(name = "after_seq")
    val afterSeq: Int?,
    @Json(name = "app_contn_btn_img_name")
    val appContnBtnImgName: Any?,
    @Json(name = "app_contn_btn_link_url")
    val appContnBtnLinkUrl: Any?,
    @Json(name = "app_contn_cntnt")
    val appContnCntnt: Any?,
    @Json(name = "app_contn_cntnt_img_name")
    val appContnCntntImgName: Any?,
    @Json(name = "app_thnl_img_name")
    val appThnlImgName: String?,
    @Json(name = "app_yn")
    val appYn: String?,
    @Json(name = "appyn")
    val appyn: String?,
    @Json(name = "banner_type")
    val bannerType: Any?,
    @Json(name = "befor_seq")
    val beforSeq: Int?,
    @Json(name = "cate")
    val cate: String?,
    @Json(name = "cate_cd")
    val cateCd: String?,
    @Json(name = "cate_nm")
    val cateNm: String?,
    @Json(name = "content")
    val content: String?,
    @Json(name = "contn_cntnt_xpsr_dvsn_code")
    val contnCntntXpsrDvsnCode: Any?,
    @Json(name = "contn_ctn_cntnt")
    val contnCtnCntnt: Any?,
    @Json(name = "csm_edt")
    val csmEdt: Any?,
    @Json(name = "csm_sdt")
    val csmSdt: Any?,
    @Json(name = "decode")
    val decode: String?,
    @Json(name = "del_yn")
    val delYn: String?,
    @Json(name = "departments")
    val departments: String?,
    @Json(name = "endDate")
    val endDate: String?,
    @Json(name = "end_dt")
    val endDt: String?,
    @Json(name = "excel_Name")
    val excelName: String?,
    @Json(name = "excel_yn")
    val excelYn: String?,
    @Json(name = "fileName")
    val fileName: String?,
    @Json(name = "file_nm")
    val fileNm: String?,
    @Json(name = "file_nm1")
    val fileNm1: String?,
    @Json(name = "file_nm2")
    val fileNm2: String?,
    @Json(name = "file_nm3")
    val fileNm3: String?,
    @Json(name = "file_type")
    val fileType: String?,
    @Json(name = "firstIndex")
    val firstIndex: Int?,
    @Json(name = "hit")
    val hit: Int?,
    @Json(name = "img_nm")
    val imgNm: String?,
    @Json(name = "img_nm_tag")
    val imgNmTag: Any?,
    @Json(name = "lastIndex")
    val lastIndex: Int?,
    @Json(name = "menu_cd")
    val menuCd: String?,
    @Json(name = "message")
    val message: Any?,
    @Json(name = "mod_dt")
    val modDt: String?,
    @Json(name = "mod_user")
    val modUser: String?,
    @Json(name = "news_dt")
    val newsDt: String?,
    @Json(name = "next_regdate")
    val nextRegdate: String?,
    @Json(name = "next_seq")
    val nextSeq: Int?,
    @Json(name = "next_title")
    val nextTitle: String?,
    @Json(name = "order_num")
    val orderNum: Int?,
    @Json(name = "pageIndex")
    val pageIndex: Int?,
    @Json(name = "pageSize")
    val pageSize: Int?,
    @Json(name = "page_status")
    val pageStatus: String?,
    @Json(name = "pageType")
    val pageType: String?,
    @Json(name = "pageUnit")
    val pageUnit: Int?,
    @Json(name = "period_type")
    val periodType: Any?,
    @Json(name = "prev_regdate")
    val prevRegdate: String?,
    @Json(name = "prev_seq")
    val prevSeq: Int?,
    @Json(name = "prev_title")
    val prevTitle: String?,
    @Json(name = "product_cd")
    val productCd: String?,
    @Json(name = "recordCountPerPage")
    val recordCountPerPage: Int?,
    @Json(name = "reg_dt")
    val regDt: String?,
    @Json(name = "reg_user")
    val regUser: String?,
    @Json(name = "resultBoolean")
    val resultBoolean: Boolean?,
    @Json(name = "resultString")
    val resultString: Any?,
    @Json(name = "rnum")
    val rnum: Int?,
    @Json(name = "row")
    val row: String?,
    @Json(name = "sSeq")
    val sSeq: String?,
    @Json(name = "san_content")
    val sanContent: String?,
    @Json(name = "san_index")
    val sanIndex: Int?,
    @Json(name = "san_openyn")
    val sanOpenyn: String?,
    @Json(name = "san_regdate")
    val sanRegdate: String?,
    @Json(name = "san_title")
    val sanTitle: String?,
    @Json(name = "search")
    val search: Any?,
    @Json(name = "searchCondition")
    val searchCondition: String?,
    @Json(name = "searchKey")
    val searchKey: String?,
    @Json(name = "searchKeyword")
    val searchKeyword: String?,
    @Json(name = "search_word")
    val searchWord: Any?,
    @Json(name = "search_word_type")
    val searchWordType: Any?,
    @Json(name = "seq")
    val seq: Int?,
    @Json(name = "startDate")
    val startDate: String?,
    @Json(name = "start_dt")
    val startDt: String?,
    @Json(name = "status")
    val status: String?,
    @Json(name = "statusPage")
    val statusPage: String?,
    @Json(name = "store_code")
    val storeCode: Any?,
    @Json(name = "sub_title_name")
    val subTitleName: String?,
    @Json(name = "tag_seq")
    val tagSeq: Int?,
    @Json(name = "tag_txt")
    val tagTxt: String?,
    @Json(name = "thum_img_yn")
    val thumImgYn: String?,
    @Json(name = "thumbnail_nm")
    val thumbnailNm: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "totalCnt")
    val totalCnt: Int?,
    @Json(name = "view_ty")
    val viewTy: Int?,
    @Json(name = "view_yn")
    val viewYn: String?,
    @Json(name = "web_contn_btn_img_name")
    val webContnBtnImgName: Any?,
    @Json(name = "web_contn_btn_link_url")
    val webContnBtnLinkUrl: Any?,
    @Json(name = "web_contn_cntnt_img_name")
    val webContnCntntImgName: Any?,
    @Json(name = "web_contn_link_nwndw_yn")
    val webContnLinkNwndwYn: Any?,
    @Json(name = "web_yn")
    val webYn: String?,
    @Json(name = "webxpsrseqc")
    val webxpsrseqc: String?,
    @Json(name = "wmonth")
    val wmonth: String?,
    @Json(name = "wyear")
    val wyear: String?,
)

data class Vo(
    @Json(name = "active_QUATER")
    val activeQUATER: String?,
    @Json(name = "active_YEAR")
    val activeYEAR: String?,
    @Json(name = "after_seq")
    val afterSeq: Int?,
    @Json(name = "app_contn_btn_img_name")
    val appContnBtnImgName: Any?,
    @Json(name = "app_contn_btn_link_url")
    val appContnBtnLinkUrl: Any?,
    @Json(name = "app_contn_cntnt")
    val appContnCntnt: Any?,
    @Json(name = "app_contn_cntnt_img_name")
    val appContnCntntImgName: Any?,
    @Json(name = "app_thnl_img_name")
    val appThnlImgName: Any?,
    @Json(name = "app_yn")
    val appYn: String?,
    @Json(name = "appyn")
    val appyn: String?,
    @Json(name = "banner_type")
    val bannerType: Any?,
    @Json(name = "befor_seq")
    val beforSeq: Int?,
    @Json(name = "cate")
    val cate: String?,
    @Json(name = "cate_cd")
    val cateCd: String?,
    @Json(name = "cate_nm")
    val cateNm: String?,
    @Json(name = "content")
    val content: String?,
    @Json(name = "contn_cntnt_xpsr_dvsn_code")
    val contnCntntXpsrDvsnCode: Any?,
    @Json(name = "contn_ctn_cntnt")
    val contnCtnCntnt: Any?,
    @Json(name = "csm_edt")
    val csmEdt: Any?,
    @Json(name = "csm_sdt")
    val csmSdt: Any?,
    @Json(name = "decode")
    val decode: String?,
    @Json(name = "del_yn")
    val delYn: String?,
    @Json(name = "departments")
    val departments: String?,
    @Json(name = "endDate")
    val endDate: String?,
    @Json(name = "end_dt")
    val endDt: Any?,
    @Json(name = "excel_Name")
    val excelName: String?,
    @Json(name = "excel_yn")
    val excelYn: String?,
    @Json(name = "fileName")
    val fileName: String?,
    @Json(name = "file_nm")
    val fileNm: String?,
    @Json(name = "file_nm1")
    val fileNm1: String?,
    @Json(name = "file_nm2")
    val fileNm2: String?,
    @Json(name = "file_nm3")
    val fileNm3: String?,
    @Json(name = "file_type")
    val fileType: String?,
    @Json(name = "firstIndex")
    val firstIndex: Int?,
    @Json(name = "hit")
    val hit: Int?,
    @Json(name = "img_nm")
    val imgNm: String?,
    @Json(name = "img_nm_tag")
    val imgNmTag: Any?,
    @Json(name = "lastIndex")
    val lastIndex: Int?,
    @Json(name = "menu_cd")
    val menuCd: String?,
    @Json(name = "message")
    val message: Any?,
    @Json(name = "mod_dt")
    val modDt: String?,
    @Json(name = "mod_user")
    val modUser: String?,
    @Json(name = "news_dt")
    val newsDt: String?,
    @Json(name = "next_regdate")
    val nextRegdate: String?,
    @Json(name = "next_seq")
    val nextSeq: Int?,
    @Json(name = "next_title")
    val nextTitle: String?,
    @Json(name = "order_num")
    val orderNum: Int?,
    @Json(name = "pageIndex")
    val pageIndex: Int?,
    @Json(name = "pageSize")
    val pageSize: Int?,
    @Json(name = "page_status")
    val pageStatus: String?,
    @Json(name = "pageType")
    val pageType: String?,
    @Json(name = "pageUnit")
    val pageUnit: Int?,
    @Json(name = "period_type")
    val periodType: Any?,
    @Json(name = "prev_regdate")
    val prevRegdate: String?,
    @Json(name = "prev_seq")
    val prevSeq: Int?,
    @Json(name = "prev_title")
    val prevTitle: String?,
    @Json(name = "product_cd")
    val productCd: String?,
    @Json(name = "recordCountPerPage")
    val recordCountPerPage: Int?,
    @Json(name = "reg_dt")
    val regDt: String?,
    @Json(name = "reg_user")
    val regUser: String?,
    @Json(name = "resultBoolean")
    val resultBoolean: Boolean?,
    @Json(name = "resultString")
    val resultString: Any?,
    @Json(name = "rnum")
    val rnum: Int?,
    @Json(name = "row")
    val row: String?,
    @Json(name = "sSeq")
    val sSeq: String?,
    @Json(name = "san_content")
    val sanContent: String?,
    @Json(name = "san_index")
    val sanIndex: Int?,
    @Json(name = "san_openyn")
    val sanOpenyn: String?,
    @Json(name = "san_regdate")
    val sanRegdate: String?,
    @Json(name = "san_title")
    val sanTitle: String?,
    @Json(name = "search")
    val search: Any?,
    @Json(name = "searchCondition")
    val searchCondition: String?,
    @Json(name = "searchKey")
    val searchKey: String?,
    @Json(name = "searchKeyword")
    val searchKeyword: String?,
    @Json(name = "search_word")
    val searchWord: Any?,
    @Json(name = "search_word_type")
    val searchWordType: Any?,
    @Json(name = "seq")
    val seq: Int?,
    @Json(name = "startDate")
    val startDate: String?,
    @Json(name = "start_dt")
    val startDt: Any?,
    @Json(name = "status")
    val status: String?,
    @Json(name = "statusPage")
    val statusPage: String?,
    @Json(name = "store_code")
    val storeCode: Any?,
    @Json(name = "sub_title_name")
    val subTitleName: Any?,
    @Json(name = "tag_seq")
    val tagSeq: Int?,
    @Json(name = "tag_txt")
    val tagTxt: String?,
    @Json(name = "thum_img_yn")
    val thumImgYn: String?,
    @Json(name = "thumbnail_nm")
    val thumbnailNm: String?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "totalCnt")
    val totalCnt: Int?,
    @Json(name = "view_ty")
    val viewTy: Int?,
    @Json(name = "view_yn")
    val viewYn: String?,
    @Json(name = "web_contn_btn_img_name")
    val webContnBtnImgName: Any?,
    @Json(name = "web_contn_btn_link_url")
    val webContnBtnLinkUrl: Any?,
    @Json(name = "web_contn_cntnt_img_name")
    val webContnCntntImgName: Any?,
    @Json(name = "web_contn_link_nwndw_yn")
    val webContnLinkNwndwYn: Any?,
    @Json(name = "web_yn")
    val webYn: String?,
    @Json(name = "webxpsrseqc")
    val webxpsrseqc: String?,
    @Json(name = "wmonth")
    val wmonth: String?,
    @Json(name = "wyear")
    val wyear: String?,
)
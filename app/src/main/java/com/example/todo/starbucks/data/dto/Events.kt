package com.example.todo.starbucks.data.dto


import com.squareup.moshi.Json

data class Events(
    @Json(name = "list")
    val events: List<EventDto>
)

data class EventDto (
    @Json(name = "app_BTN_IMG")
    val appBTNIMG: String?,
    @Json(name = "app_CONTN_BTN_LINK_URL")
    val appCONTNBTNLINKURL: Any?,
    @Json(name = "app_XPSR_YN")
    val appXPSRYN: Any?,
    @Json(name = "banner_TYPE")
    val bannerTYPE: Any?,
    @Json(name = "capacity")
    val capacity: String?,
    @Json(name = "content")
    val content: String?,
    @Json(name = "content_MOBILE")
    val contentMOBILE: String?,
    @Json(name = "content_TABLET")
    val contentTABLET: String?,
    @Json(name = "contn_CNTNT_XPSR_DVSN_CODE")
    val contnCNTNTXPSRDVSNCODE: Any?,
    @Json(name = "contn_CTN_CNTNT")
    val contnCTNCNTNT: Any?,
    @Json(name = "del_YN")
    val delYN: String?,
    @Json(name = "end_DT")
    val endDT: String?,
    @Json(name = "end_HOUR")
    val endHOUR: String?,
    @Json(name = "end_MINUTE")
    val endMINUTE: String?,
    @Json(name = "etc_MEMO")
    val etcMEMO: String?,
    @Json(name = "event_PAGE_NAME")
    val eventPAGENAME: String?,
    @Json(name = "file_CD")
    val fileCD: String?,
    @Json(name = "file_DEL_ARRAY")
    val fileDELARRAY: Any?,
    @Json(name = "file_NM")
    val fileNM: String?,
    @Json(name = "file_SEQ")
    val fileSEQ: Int?,
    @Json(name = "first_INDEX")
    val firstINDEX: Int?,
    @Json(name = "flash_H")
    val flashH: String?,
    @Json(name = "flash_NM")
    val flashNM: String?,
    @Json(name = "flash_W")
    val flashW: String?,
    @Json(name = "hit")
    val hit: String?,
    @Json(name = "img_NM")
    val imgNM: String?,
    @Json(name = "img_UPLOAD_PATH")
    val imgUPLOADPATH: String?,
    @Json(name = "last_INDEX")
    val lastINDEX: Int?,
    @Json(name = "menu_CD")
    val menuCD: String?,
    @Json(name = "menu_CD_ARR")
    val menuCDARR: Any?,
    @Json(name = "mob_IMG")
    val mobIMG: String?,
    @Json(name = "mob_IMG_SEQ")
    val mobIMGSEQ: Int?,
    @Json(name = "mob_THUM")
    val mobTHUM: String?,
    @Json(name = "mob_THUM_SEQ")
    val mobTHUMSEQ: Int?,
    @Json(name = "mod_DT")
    val modDT: String?,
    @Json(name = "mod_USER")
    val modUSER: String?,
    @Json(name = "online_YN")
    val onlineYN: String?,
    @Json(name = "page")
    val page: Int?,
    @Json(name = "page_INDEX")
    val pageINDEX: Int?,
    @Json(name = "page_SIZE")
    val pageSIZE: Int?,
    @Json(name = "page_UNIT")
    val pageUNIT: Int?,
    @Json(name = "pagesize")
    val pagesize: Int?,
    @Json(name = "pro_CON_SEQ")
    val proCONSEQ: Int?,
    @Json(name = "pro_SEQ")
    val proSEQ: Int?,
    @Json(name = "product_CD")
    val productCD: String?,
    @Json(name = "record")
    val record: Int?,
    @Json(name = "record_COUNT_PER_PAGE")
    val recordCOUNTPERPAGE: Int?,
    @Json(name = "reg_DT")
    val regDT: String?,
    @Json(name = "reg_USER")
    val regUSER: String?,
    @Json(name = "rnum")
    val rnum: Int?,
    @Json(name = "sbtitle_NAME")
    val sbtitleNAME: String?,
    @Json(name = "search_DATE_TYPE")
    val searchDATETYPE: String?,
    @Json(name = "search_END_DATE")
    val searchENDDATE: String?,
    @Json(name = "search_END_YN")
    val searchENDYN: String?,
    @Json(name = "search_KEY")
    val searchKEY: String?,
    @Json(name = "search_MENU_CD")
    val searchMENUCD: String?,
    @Json(name = "search_START_DATE")
    val searchSTARTDATE: String?,
    @Json(name = "search_VALUE")
    val searchVALUE: String?,
    @Json(name = "search_VIEW_YN")
    val searchVIEWYN: String?,
    @Json(name = "seq")
    val seq: String?,
    @Json(name = "start_DT")
    val startDT: String?,
    @Json(name = "start_HOUR")
    val startHOUR: String?,
    @Json(name = "start_MINUTE")
    val startMINUTE: String?,
    @Json(name = "stat")
    val stat: String?,
    @Json(name = "status")
    val status: String?,
    @Json(name = "store_CD")
    val storeCD: String?,
    @Json(name = "store_CNT")
    val storeCNT: Int?,
    @Json(name = "store_CODE")
    val storeCODE: Any?,
    @Json(name = "store_GUBUN")
    val storeGUBUN: String?,
    @Json(name = "store_MEMO")
    val storeMEMO: String?,
    @Json(name = "store_NM")
    val storeNM: String?,
    @Json(name = "str_SEQ")
    val strSEQ: Int?,
    @Json(name = "sub_VIEW")
    val subVIEW: String?,
    @Json(name = "tab_IMG")
    val tabIMG: String?,
    @Json(name = "tab_IMG_SEQ")
    val tabIMGSEQ: Int?,
    @Json(name = "tab_THUM")
    val tabTHUM: String?,
    @Json(name = "tab_THUM_SEQ")
    val tabTHUMSEQ: Int?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "top_DATE")
    val topDATE: String?,
    @Json(name = "top_YN")
    val topYN: String?,
    @Json(name = "total_CNT")
    val totalCNT: Int?,
    @Json(name = "view_DATE")
    val viewDATE: String?,
    @Json(name = "view_EDT1")
    val viewEDT1: String?,
    @Json(name = "view_EDT2")
    val viewEDT2: String?,
    @Json(name = "view_ORDER")
    val viewORDER: String?,
    @Json(name = "view_SDT1")
    val viewSDT1: String?,
    @Json(name = "view_SDT2")
    val viewSDT2: String?,
    @Json(name = "view_TYPE")
    val viewTYPE: String?,
    @Json(name = "view_YN")
    val viewYN: String?,
    @Json(name = "web_BTN_IMG")
    val webBTNIMG: String?,
    @Json(name = "web_CONTN_BTN_LINK_URL")
    val webCONTNBTNLINKURL: Any?,
    @Json(name = "web_CONTN_LINK_NWNDW_YN")
    val webCONTNLINKNWNDWYN: Any?,
    @Json(name = "web_IMG")
    val webIMG: String?,
    @Json(name = "web_IMG_SEQ")
    val webIMGSEQ: Int?,
    @Json(name = "web_THUM")
    val webTHUM: String?,
    @Json(name = "web_THUM_SEQ")
    val webTHUMSEQ: Int?,
    @Json(name = "web_XPSR_YN")
    val webXPSRYN: Any?,
    @Json(name = "webxpsrseqc")
    val webxpsrseqc: String?
)
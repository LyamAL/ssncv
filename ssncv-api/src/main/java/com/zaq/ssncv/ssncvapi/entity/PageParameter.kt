package com.zaq.ssncv.ssncvapi.entity

/**
 * @program: squarenavigationsys
 * @description:PageParameter
 * @author:  chenzhicai
 * @create: 2018-11-01-19-08
 **/
class PageParameter {
    val DEFAULT_PAGE_SIZE = 10
    private var pageSize: Int = 0
    private var currentPage: Int = 0
    private var prePage: Int = 0
    private var nextPage: Int = 0
    private var recordsTotal: Long? = 1L
    private var recordsFiltered = 1
    private var orders: String? = null

    constructor() {
        this.currentPage = 1
        this.pageSize = 10
    }

    constructor(currentPage: Int, pageSize: Int) {
        this.currentPage = currentPage
        this.pageSize = pageSize
    }

    fun getCurrentPage(): Int {
        return this.currentPage
    }

    fun setCurrentPage(currentPage: Int) {
        this.currentPage = currentPage
    }

    fun getPageSize(): Int {
        return this.pageSize
    }

    fun setPageSize(pageSize: Int) {
        this.pageSize = pageSize
    }

    fun getPrePage(): Int {
        return this.prePage
    }

    fun setPrePage(prePage: Int) {
        this.prePage = prePage
    }

    fun getNextPage(): Int {
        return this.nextPage
    }

    fun setNextPage(nextPage: Int) {
        this.nextPage = nextPage
    }

    fun getOrders(): String? {
        return this.orders
    }

    fun getRecordsTotal(): Long? {
        return this.recordsTotal
    }

    fun setRecordsTotal(recordsTotal: Long?) {
        this.recordsTotal = recordsTotal
    }

    fun getRecordsFiltered(): Int {
        return this.recordsFiltered
    }

    fun setRecordsFiltered(recordsFiltered: Int) {
        this.recordsFiltered = recordsFiltered
    }

    fun setOrders(orders: String) {
        this.orders = orders
    }
}
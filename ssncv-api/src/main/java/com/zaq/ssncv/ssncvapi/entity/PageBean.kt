package com.zaq.ssncv.ssncvapi.entity

import lombok.*
import java.io.Serializable
import java.math.BigDecimal

/**
 * @program: squarenavigationsys
 * @description:分页bean
 * @author:  chenzhicai
 * @create: 2018-11-01-19-02
 **/
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
class PageBean<T> : Serializable {
    private val serialVersionUID = -3964286237745062463L
    private var data: List<T>? = null
    private var page = PageParameter()
    private var parameter: T? = null
    private var recordsTotal: Long? = 1L
    private var recordsFiltered: Long? = 1L
    private var draw: Int = 0
    private var actualStock: Int? = null
    private var fictitiousStock: Int? = null
    private var balance: BigDecimal? = null
    private var ids: Array<Long>? = null
    fun getIds(): Array<Long>? {
        return this.ids
    }

    fun setIds(ids: Array<Long>) {
        this.ids = ids
    }

    fun getData(): List<T>? {
        return this.data
    }

    fun setData(data: List<T>) {
        this.data = data
    }

    fun getPage(): PageParameter {
        return this.page
    }

    fun setPage(page: PageParameter) {
        this.page = page
    }

    fun getParameter(): T? {
        return this.parameter
    }

    fun setParameter(parameter: T) {
        this.parameter = parameter
    }

    fun getRecordsTotal(): Long? {
        return this.recordsTotal
    }

    fun setRecordsTotal(recordsTotal: Long?) {
        this.recordsTotal = recordsTotal
    }

    fun getRecordsFiltered(): Long? {
        return this.recordsFiltered
    }

    fun setRecordsFiltered(recordsFiltered: Long?) {
        this.recordsFiltered = recordsFiltered
    }

    fun getDraw(): Int {
        return this.draw
    }

    fun setDraw(draw: Int) {
        this.draw = draw
    }

    fun getActualStock(): Int? {
        return this.actualStock
    }

    fun setActualStock(actualStock: Int?) {
        this.actualStock = actualStock
    }

    fun getFictitiousStock(): Int? {
        return this.fictitiousStock
    }

    fun setFictitiousStock(fictitiousStock: Int?) {
        this.fictitiousStock = fictitiousStock
    }

    fun getBalance(): BigDecimal? {
        return this.balance
    }

    fun setBalance(balance: BigDecimal) {
        this.balance = balance
    }

}
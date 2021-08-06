package com.vinod.taskcorousal

object Utils {
    const val PAGES = 10

    fun getPageWiseData(): MutableMap<Int, MutableList<String>> {
        var hm = mutableMapOf<Int, MutableList<String>>()
        for (page in 0..PAGES) {
            hm[page] = (1..100).map { "PAGE ${page + 1}, Item: $it" }.toMutableList()
        }
        return hm
    }

    fun getFilteredData(str: String, list: MutableList<String>): MutableList<String> {
        return if (str.isNullOrEmpty())
            list
        else
            list.filter { it.contains(str,ignoreCase = true) }.toMutableList()

    }
}
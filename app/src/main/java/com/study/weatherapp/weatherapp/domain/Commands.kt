package com.study.weatherapp.weatherapp.domain

import com.study.weatherapp.weatherapp.ForecastRequest

public interface Command<T> {

    fun execute(): T

}

class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}
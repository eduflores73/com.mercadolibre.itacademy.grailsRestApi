package com.mercadolibre.itacademy

import grails.rest.RestfulController

class RoomController extends RestfulController<Room>{

    static responseFormats = ['json']

    RoomController() {
        super(Room)
    }

    @Override
    def index() {
        def hotelId = params.hotelId
        if(hotelId != null) {
            respond Room.where {
                hotel.id == hotelId
            }.list()
        } else {
            respond Room.list()
        }
    }
}
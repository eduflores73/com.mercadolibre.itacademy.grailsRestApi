package com.mercadolibre.itacademy

import grails.converters.JSON

import java.text.SimpleDateFormat

class BootStrap {

    def init = { servletContext ->

        def marca1 = new Marca(name:'Adidas').save(flush:true)
        def marca2 = new Marca(name:'Nike').save(flush:true)
        def marca3 = new Marca(name:'Samsung').save(flush:true)
        marca1.addToArticulo(new Articulo(name: 'zapatilla', picture:'https://http2.mlstatic.com/celular-samsung-galaxy-j6-liberado-D_NQ_NP_663414-MLA31514835435_072019-F.webp',total_items_in_this_category: 2)).save()

        marca1.addToArticulo(new Articulo(name: 'remera', picture:'https://http2.mlstatic.com/celular-samsung-galaxy-j6-liberado-D_NQ_NP_663414-MLA31514835435_072019-F.webp',total_items_in_this_category: 3)).save()
        marca1.addToArticulo(new Articulo(name: 'media', picture:'https://http2.mlstatic.com/celular-samsung-galaxy-j6-liberado-D_NQ_NP_663414-MLA31514835435_072019-F.webp',total_items_in_this_category: 23)).save()

        marca2.addToArticulo(new Articulo(name: 'pantalon', picture:'https://http2.mlstatic.com/celular-samsung-galaxy-j6-liberado-D_NQ_NP_663414-MLA31514835435_072019-F.webp',total_items_in_this_category: 34)).save()
        marca2.addToArticulo(new Articulo(name: 'buzo', picture:'https://http2.mlstatic.com/celular-samsung-galaxy-j6-liberado-D_NQ_NP_663414-MLA31514835435_072019-F.webp',total_items_in_this_category: 25)).save()
        marca2.addToArticulo(new Articulo(name: 'malla', picture:'https://http2.mlstatic.com/celular-samsung-galaxy-j6-liberado-D_NQ_NP_663414-MLA31514835435_072019-F.webp',total_items_in_this_category: 26)).save()

        marca3.addToArticulo(new Articulo(name: 'J100', picture:'https://http2.mlstatic.com/celular-samsung-galaxy-j6-liberado-D_NQ_NP_663414-MLA31514835435_072019-F.webp',total_items_in_this_category: 26)).save()
        marca3.addToArticulo(new Articulo(name: 'J200', picture:'https://http2.mlstatic.com/celular-samsung-galaxy-j6-liberado-D_NQ_NP_663414-MLA31514835435_072019-F.webp',total_items_in_this_category: 27)).save()
        marca3.addToArticulo(new Articulo(name: 'J300', picture:'https://http2.mlstatic.com/celular-samsung-galaxy-j6-liberado-D_NQ_NP_663414-MLA31514835435_072019-F.webp',total_items_in_this_category: 24)).save()


        marshalerMarcaArticulo()
    }


    private void marshalerMarcaArticulo(){
        JSON.registerObjectMarshaller(Marca){
            marca -> [
                    id: marca.id,
                    name: marca.name,
                    articulos: marca.articulo.collect{
                        articulo -> [
                                id: articulo.id,
                                name: articulo.name,
                                picture: articulo.picture,
                                total_items_in_this_category: articulo.total_items_in_this_category,
                                children_categories: []
                        ]
                    }
            ]
        }
    }

    private void marshalerArticulo(){
        JSON.registerObjectMarshaller(Articulo){
            articulo -> [
                    id: articulo.id,
                    name: articulo.name,
                    picture: articulo.picture,
                    total_items_in_this_category: articulo.total_items_in_this_category,
                    children_categories: []
            ]
        }
    }
}

package com.mercadolibre.itacademy

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')

        "/hotels" (resources:"hotel") {
            "/rooms" (resources: "room")
        }

        "/rooms" (resources: "room")

        "/hotels" (resources:"hotel")

        "/marcas" (resources:"marca") {
            "/articulos" (resources: "articulo")
        }

        "/articulos" (resources: "articulo")

        "/marcas" (resources:"marca")
    }
}

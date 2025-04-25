#language: es

Característica: Automatizar e-commerce Aliexpress

  @AgregarProducto
  Esquema del escenario: Agregar un producto al carrito de compras
    Dado que el usuario se encuentra en la pagina '<url>'
    Cuando busca un producto '<producto>'
    Y agrega la cantidad de <cantidadProducto> veces el producto al carrito
    Entonces el producto '<producto>' debe visualizarse en el carrito con su precio total

    Ejemplos:
      | url | producto | cantidadProducto |
    ##@externaldata@parametros/Datos.xlsx@AgregarProducto

# 🛒 Proyecto Bazar – API REST con Spring Boot

Aplicación monolítica desarrollada en Java con Spring Boot como **Trabajo Integrador Final** del curso **“Desarrollo de APIs en Java con Spring Boot”** de TodoCode Academy.

---

## 🧩 Tecnologías utilizadas

- Java 17  
- Spring Boot 3  
- Spring Data JPA  
- MySQL 8  
- Maven    
- Postman

## 🔧 Funcionalidades implementadas

La API REST permite gestionar de forma completa las siguientes entidades:

| Entidad   | Descripción                         |
|-----------|-------------------------------------|
| Producto  | CRUD de productos y control de stock |
| Cliente   | CRUD de clientes                     |
| Venta     | Registro y gestión de ventas         |

### Endpoints destacados

- **Productos**
  - `POST /productos/crear` – Crear producto
  - `GET /productos` – Listar productos
  - `GET /productos/{codigo}` – Obtener producto por código
  - `DELETE /productos/eliminar/{codigo}` – Eliminar producto
  - `PUT /productos/editar/{codigo}` – Editar producto
  - `GET /productos/falta_stock` – Productos con stock menor a 5

- **Clientes**
  - `POST /clientes/crear` – Crear cliente
  - `GET /clientes` – Listar clientes
  - `GET /clientes/{id}` – Obtener cliente
  - `DELETE /clientes/eliminar/{id}` – Eliminar cliente
  - `PUT /clientes/editar/{id}` – Editar cliente

- **Ventas**
  - `POST /ventas/crear` – Registrar venta
  - `GET /ventas` – Listar ventas
  - `GET /ventas/{codigo}` – Obtener venta por código
  - `DELETE /ventas/eliminar/{codigo}` – Eliminar venta
  - `PUT /ventas/editar/{codigo}` – Editar venta
  - `GET /ventas/productos/{codigo}` – Productos de una venta
  - `GET /ventas/{fecha}` – Ventas de un día (monto y cantidad)
  - `GET /ventas/mayor_venta` – Obtener la venta con mayor monto

---

## 📝 Notas

- La base de datos utilizada es **MySQL**.
- El proyecto sigue el patrón **monolítico** pero estructurado en capas: Controller, Service, Repository, Entity y DTO.
- Se utilizaron buenas prácticas de desarrollo backend en Java con Spring Boot.

---

## 🎯 Objetivo

Este proyecto representa la aplicación práctica de todo lo aprendido en el curso. Forma parte de mi **portafolio como desarrollador backend** y demuestra conocimientos sólidos en diseño de APIs RESTful, JPA, manejo de relaciones y lógica de negocio en Java.

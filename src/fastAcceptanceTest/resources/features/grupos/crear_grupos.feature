# language: es

Característica: Crear Grupo para repartir gastos

  Regla: Los grupos están compuestos por al menos dos miembros

    Escenario: No puedo crear un grupo con un único miembro
      Cuando el usuario intenta crear un grupo indicando un único miembro
      Entonces no debería crear el grupo con un único miembro

  Regla: Un grupo no puede tener miembros duplicados

    Escenario: Crear un grupo con miembros distintos
      Cuando el usuario intenta crear un grupo con los miembros "ana" y "luis"
      Entonces el grupo queda formado correctamente

    Escenario: Crear un grupo con miembros duplicados
      Cuando el usuario intenta crear un grupo con los miembros "ana" y "ana"
      Entonces el sistema rechaza la creación del grupo

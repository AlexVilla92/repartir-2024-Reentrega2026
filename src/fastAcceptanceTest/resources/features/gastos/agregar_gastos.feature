# language: es
Característica: Agregar gastos a un grupo

  Regla: El monto de un gasto no puede ser negativo

    Escenario: Registrar un gasto con monto válido
      Dado que existe un grupo con los miembros "ana" y "luis"
      Cuando "ana" registra un gasto de 500 pesos
      Entonces el gasto queda registrado en el grupo

    Escenario: Registrar un gasto con monto negativo
      Dado que existe un grupo con los miembros "ana" y "luis"
      Cuando "ana" intenta registrar un gasto de -500 pesos
      Entonces el sistema rechaza el gasto

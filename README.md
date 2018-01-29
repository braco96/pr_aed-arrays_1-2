# AED — Arrays con Maven
**Autor:** Luis Bravo  
**Curso:** 2017–2018  
**Asignatura:** Algoritmos y Estructuras de Datos (UPM)

Proyecto Maven con separación por capas:
- `src/main/java/aed/` → **código fuente** (`Arrays1.java`, `Arrays2.java`) y **mains** (`MainArrays1`, `MainArrays2`)
- `src/test/java/aed/` → **tests** (se incluyen `Tester1.java`, `Tester2.java`) y un test mínimo JUnit
- `docs/guia.pdf` → enunciado del laboratorio

Especificaciones resumidas (ver doc para detalles):
- `Arrays1.compactar(Integer[])` — compacta consecutivos iguales en un nuevo array; parámetro no nulo.
- `Arrays2.sonInversos(Integer[], Integer[])` — `true` si contienen los mismos elementos en orden inverso (permitidos `null`).

## Uso
```bash
# Compilar y ejecutar tests
mvn -q -DskipTests=false test

# Ejecutar MainArrays1
mvn -q -Dexec.mainClass=aed.MainArrays1 exec:java

# Ejecutar MainArrays2
mvn -q -Dexec.mainClass=aed.MainArrays2 exec:java
```

— Luis Bravo
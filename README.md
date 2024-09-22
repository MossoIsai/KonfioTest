##  KonfioTest (Este proyecto utiliza clean architecture + MVVM )
## Dog List
![Screenshot_20240921_114616](https://github.com/user-attachments/assets/7485afe7-f7bd-466f-8317-5d05b757d467)


```



En la capa de presentación esta todo lo relacionado a la ui y algunos otros elementos que se consideran de presentación

```sh
 - Presentation
   - ui
   - uistate
   - viewmodel
   - di
   - extesions
```
La capa de dominio es responsable de encapsular la lógica empresarial compleja o la lógica empresarial simple que es reutilizada por múltiples ViewModels.
```sh
 - domain
   - usecase
   - repository(interface)
   - entities
   - mappings(convierte modelos de data a dominio)
```
La capa de datos contiene datos de aplicación y lógica empresarial. La lógica de negocios es lo que le da valor a su aplicación: está compuesta de reglas comerciales del mundo real que determinan cómo se deben crear, almacenar y cambiar los datos de la aplicación.
```sh
 - data
   - repository(implementación)
   - api(endpoints)
   - models
   - resource ->

             - local (database, SharedPreferences, DataStore, ProtoDataStore)
             - remote (web service, Firebase etc.)
```






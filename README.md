# **Projekt SmartHome**
**Avetis Mkrtchian**

# ***Průběh simulace***
Průběh naší simulace řídí třída Controller, která je spuštěna hlavní třídou Main. Controller má v sobě cyklus (metodu start), která představuje běh domu. Jeden průběh cyklem představuje jednu hodinu v domu. V každém cyklu se aktualizují metodou tick() všechny třídy dědící ze třídy EventSubscriber (zařízení, sportovní náčiní, lidé, zvířata). Tyto entity mohou generovat nějaké eventy, které se následně přidají do Controlleru. Tyto eventy jsou následně přebrány vyhovujícím prvkem domu.

# ***Návrhové vzory***

**Composite**
- přes třídu BuildingComponent
- ve třídách: House, Floor, Room, Appliance

**Factory**
- ve třídě: CreaturesFactory

**Singleton**
- ve třídách: House, Controller, HouseInfReport, EventReport, CreaturesReport

**Chain of resposibility**
- ve třídě: Controller (v metodě: allSubscribersHandleEvent(BabyRepackEvent event))

**State Machine**
- všechny třídy v package: src/main/java/cz/cvut/fel/omo/building/building_equipment/stateMachine , src/main/java/cz/cvut/fel/omo/creatures/stateMachine

**Lazy initialization**
- ve třídě: Manual
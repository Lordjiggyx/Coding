package Example3;

class OneStoryHouse extends HouseBuilder {
    
    public OneStoryHouse(String features) {
        house.setType(this.getClass() + " " + features);
    }
    public void buildFoundation() {
        //doEngineering()
        //doExcavating()
        //doPlumbingHeatingElectricity()
        //doSewerWaterHookUp()
        //doFoundationInspection()
        house.setProgress("foundation is done");
    }

    public void buildFrame() {
        //doHeatingPlumbingRoof()
        //doElectricityRoute()
        //doDoorsWindows()
        //doFrameInspection()
        house.setProgress("frame is done");
    }

    public void buildExterior() {
        //doOverheadDoors()
        //doBrickWorks()
        //doSidingsoffitsGutters()
        //doDrivewayGarageFloor()
        //doDeckRail()
        //doLandScaping()
        house.setProgress("Exterior is done");
    }

    public void buildInterior() {
        //doAlarmPrewiring()
        //doBuiltinVacuum()
        //doInsulation()
        //doDryWall()
        //doPainting()
        //doLinoleum()
        //doCabinet()
        //doTileWork()
        //doLightFixtureBlinds()
        //doCleaning()
        //doInteriorInspection()
        house.setProgress("Interior is under going");
    } 
}
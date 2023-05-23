package sockyProxy;
import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;
import burp.api.montoya.logging.Logging;
import sockyProxy.GUI.sockyTableModel;

public class sockyProxy implements BurpExtension {
	public MontoyaApi api;
	@Override
	public void initialize(MontoyaApi api) {
		// TODO Auto-generated method stub
		this.api = api;
        // set extension name
        api.extension().setName("sockyProxy");
        // write a message to our output stream
        api.logging().logToOutput("sockyProxy loaded.");
        api.logging().logToOutput("Is Python Installed: " + String.valueOf(Utils.isPythonInstalled()));
        if (!Utils.isPythonInstalled()) {
        	api.logging().logToOutput("You must install Python3 on your host system (with aiohttp and websockets library installed) and ensure python3 is in your PATH environment variable");
        	return;
        }
        //Register web socket handler with Burp.
        GUI UI;
        api.userInterface().registerSuiteTab("sockyProxy", UI = new GUI(api));
        wsCreateHandler exampleWebSocketCreationHandler = new wsCreateHandler(api,UI.stm);
        api.websockets().registerWebSocketCreatedHandler(exampleWebSocketCreationHandler);
        Utils.LaunchProxy(UI.tbPort.getText(), UI.tbWebsocketURL.getText());
	}

}

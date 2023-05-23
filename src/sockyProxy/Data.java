package sockyProxy;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import burp.api.montoya.http.handler.HttpResponseReceived;
import burp.api.montoya.websocket.TextMessage;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

public class Data {
	public class wSocketMessage {
		private TextMessage _txtMsg;
		private	LocalDateTime _timestamp;
		
		public TextMessage getMessage() {
			return _txtMsg;
		}
		
		public void setMessage(TextMessage message) {
			this._txtMsg = message;
		}
		
		public LocalDateTime getTimestamp() {
			return _timestamp;
		}
		
		public void setTimestamp() {
			LocalDateTime ts = LocalDateTime.now();
			this._timestamp = ts;
		}
	}

}

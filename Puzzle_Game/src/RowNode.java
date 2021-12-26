
public class RowNode {
		private String RowCode;
		private RowNode Down;
		private Node right;
		
		
		public RowNode(String dataToAdd) {
			
			RowCode = dataToAdd;
			Down = null;
			right = null;
		}


		public String getRowCode() {
			return RowCode;
		}


		public void setRowCode(String rowCode) {
			RowCode = rowCode;
		}


		public RowNode getDown() {
			return Down;
		}


		public void setDown(RowNode down) {
			Down = down;
		}


		public Node getRight() {
			return right;
		}


		public void setRight(Node right) {
			this.right = right;
		}
		
}

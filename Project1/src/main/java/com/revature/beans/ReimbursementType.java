package com.revature.beans;

public class ReimbursementType {

		private int reimb_type_id;
		private String reimb_type;
		public ReimbursementType() {
			super();
			// TODO Auto-generated constructor stub
		}
		public ReimbursementType(int reimb_type_id, String reimb_type) {
			super();
			this.reimb_type_id = reimb_type_id;
			this.reimb_type = reimb_type;
		}
		public int getReimb_type_id() {
			return reimb_type_id;
		}
		public void setReimb_type_id(int reimb_type_id) {
			this.reimb_type_id = reimb_type_id;
		}
		public String getReimb_type() {
			return reimb_type;
		}
		public void setReimb_type(String reimb_type) {
			this.reimb_type = reimb_type;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((reimb_type == null) ? 0 : reimb_type.hashCode());
			result = prime * result + reimb_type_id;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ReimbursementType other = (ReimbursementType) obj;
			if (reimb_type == null) {
				if (other.reimb_type != null)
					return false;
			} else if (!reimb_type.equals(other.reimb_type))
				return false;
			if (reimb_type_id != other.reimb_type_id)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "ReimbursementType [reimb_type_id=" + reimb_type_id + ", reimb_type=" + reimb_type + "]";
		}
		
		
}

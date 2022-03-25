package com.project2springbootrestspringdataers.pojo;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class ErsProofImagePojo {
	private int reimbursementId;
	private int requestingEmployeeId;
	private String photo;
	private MultipartFile file;
	private byte[] tphoto;
	
	public ErsProofImagePojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErsProofImagePojo(int reimbursementId, int requestingEmployeeId, String photo, MultipartFile file,
			byte[] tphoto) {
		super();
		this.reimbursementId = reimbursementId;
		this.requestingEmployeeId = requestingEmployeeId;
		this.photo = photo;
		this.file = file;
		this.tphoto = tphoto;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getRequestingEmployeeId() {
		return requestingEmployeeId;
	}

	public void setRequestingEmployeeId(int requestingEmployeeId) {
		this.requestingEmployeeId = requestingEmployeeId;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public byte[] getTphoto() {
		return tphoto;
	}

	public void setTphoto(byte[] tphoto) {
		this.tphoto = tphoto;
	}

	@Override
	public String toString() {
		return "ErsProofImagePojo [reimbursementId=" + reimbursementId + ", requestingEmployeeId="
				+ requestingEmployeeId + ", photo=" + photo + ", file=" + file + ", tphoto=" + Arrays.toString(tphoto)
				+ "]";
	}
	
	

}

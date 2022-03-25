package com.project2springbootrestspringdataers.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="reimbursement_proof")
public class ErsProofImageEntity {
	private int reimbursementId;
	private int requestingEmployeeId;
	
	//this is to hold an image
	private MultipartFile file;
	@Lob
	private byte[] tphoto;
	
	public ErsProofImageEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErsProofImageEntity(int reimbursementId, int requestingEmployeeId, MultipartFile file, byte[] tphoto) {
		super();
		this.reimbursementId = reimbursementId;
		this.requestingEmployeeId = requestingEmployeeId;
		this.file = file;
		this.tphoto = tphoto;
	}
	
	@Id
	@GeneratedValue
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
	
	@Transient
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
		return "ErsProofImageEntity [reimbursementId=" + reimbursementId + ", requestingEmployeeId="
				+ requestingEmployeeId + ", file=" + file + ", tphoto=" + Arrays.toString(tphoto) + "]";
	}
	
	
	
}

package com.tradeai.users.ui.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserRestUpdateRequest {
	
	private String userId;
	private String password;
	private String type;

}

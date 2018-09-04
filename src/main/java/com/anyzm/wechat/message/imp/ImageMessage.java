package com.anyzm.wechat.message.imp;

import com.anyzm.wechat.message.BaseMessage;

public class ImageMessage extends BaseMessage {
	private Image Image;

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}
}

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.07.09 at 10:56:16 AM CST 
//


package com.anyzm.wechat.message;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ToUserName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FromUserName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="CreateTime" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="MsgType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Content" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Image" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="MediaId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Voice" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="MediaId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Video" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="MediaId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Music" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="MusicUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="HQMusicUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="ThumbMediaId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ArticleCount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Articles" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="PicUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="Url" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="TransInfo" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="KfAccount" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "toUserName",
    "fromUserName",
    "createTime",
    "msgType",
    "content",
    "image",
    "voice",
    "video",
    "music",
    "mediaId",
    "articleCount",
    "articles",
    "transInfo",
     "location_X",
     "location_Y",
     "scale",
     "label",
      "picUrl",
      "format"
})
@XmlRootElement(name = "xml")
public class SendXml {

    @XmlElement(name = "ToUserName", required = true)
    protected String toUserName;
    @XmlElement(name = "FromUserName", required = true)
    protected String fromUserName;
    @XmlElement(name = "CreateTime", required = true)
    protected String createTime = String.valueOf(System.currentTimeMillis());
    @XmlElement(name = "MsgType", required = true)
    protected String msgType;
    @XmlElement(name = "Content")
    protected String content;
    @XmlElement(name = "Image")
    protected Image image;
    @XmlElement(name = "Voice")
    protected Voice voice;
    @XmlElement(name = "Video")
    protected Video video;
    @XmlElement(name = "Music")
    protected Music music;
    @XmlElement(name = "ArticleCount")
    protected String articleCount;
    @XmlElement(name = "Articles")
    protected Articles articles;
    @XmlElement(name = "TransInfo")
    protected TransInfo transInfo;

    @XmlElement(name = "Location_X")
    protected String location_X;

    @XmlElement(name = "Location_Y")
    protected String location_Y;

    @XmlElement(name = "Label")
    protected String label;

    @XmlElement(name = "Scale")
    protected String scale;

    @XmlElement(name = "MediaId")
    protected String mediaId;
    @XmlElement(name = "Format")
    protected String format;

    @XmlElement(name = "PicUrl")
    protected String picUrl;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    /**
     * Gets the value of the toUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToUserName() {
        return toUserName;
    }

    public String getLocation_X() {
        return location_X;
    }

    public void setLocation_X(String location_X) {
        location_X = location_X;
    }

    public String getLocation_Y() {
        return location_Y;
    }

    public void setLocation_Y(String location_Y) {
        location_Y = location_Y;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        label = label;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    /**
     * Sets the value of the toUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToUserName(String value) {
        this.toUserName = value;
    }

    /**
     * Gets the value of the fromUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromUserName() {
        return fromUserName;
    }

    /**
     * Sets the value of the fromUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromUserName(String value) {
        this.fromUserName = value;
    }

    /**
     * Gets the value of the createTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * Sets the value of the createTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateTime(String value) {
        this.createTime = value;
    }

    /**
     * Gets the value of the msgType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * Sets the value of the msgType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgType(String value) {
        this.msgType = value;
    }

    /**
     * Gets the value of the content property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * @return
     *     possible object is
     *     {@link Image }
     *     
     */
    public Image getImage() {
        return image;
    }

    /**
     * Sets the value of the image property.
     * 
     * @param value
     *     allowed object is
     *     {@link Image }
     *     
     */
    public void setImage(Image value) {
        this.image = value;
    }

    /**
     * Gets the value of the voice property.
     * 
     * @return
     *     possible object is
     *     {@link Voice }
     *     
     */
    public Voice getVoice() {
        return voice;
    }

    /**
     * Sets the value of the voice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Voice }
     *     
     */
    public void setVoice(Voice value) {
        this.voice = value;
    }

    /**
     * Gets the value of the video property.
     * 
     * @return
     *     possible object is
     *     {@link Video }
     *     
     */
    public Video getVideo() {
        return video;
    }

    /**
     * Sets the value of the video property.
     * 
     * @param value
     *     allowed object is
     *     {@link Video }
     *     
     */
    public void setVideo(Video value) {
        this.video = value;
    }

    /**
     * Gets the value of the music property.
     * 
     * @return
     *     possible object is
     *     {@link Music }
     *     
     */
    public Music getMusic() {
        return music;
    }

    /**
     * Sets the value of the music property.
     * 
     * @param value
     *     allowed object is
     *     {@link Music }
     *     
     */
    public void setMusic(Music value) {
        this.music = value;
    }

    /**
     * Gets the value of the articleCount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArticleCount() {
        return articleCount;
    }

    /**
     * Sets the value of the articleCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArticleCount(String value) {
        this.articleCount = value;
    }

    /**
     * Gets the value of the articles property.
     * 
     * @return
     *     possible object is
     *     {@link Articles }
     *     
     */
    public Articles getArticles() {
        return articles;
    }

    /**
     * Sets the value of the articles property.
     * 
     * @param value
     *     allowed object is
     *     {@link Articles }
     *     
     */
    public void setArticles(Articles value) {
        this.articles = value;
    }

    /**
     * Gets the value of the transInfo property.
     * 
     * @return
     *     possible object is
     *     {@link TransInfo }
     *     
     */
    public TransInfo getTransInfo() {
        return transInfo;
    }

    /**
     * Sets the value of the transInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransInfo }
     *     
     */
    public void setTransInfo(TransInfo value) {
        this.transInfo = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="item" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="PicUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="Url" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */



    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "item"
    })
    public static class Articles {

        @XmlElement(required = true)
        protected List<Item> item;

        /**
         * Gets the value of the item property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Item }
         * 
         * 
         */
        public List<Item> getItem() {
            if (item == null) {
                item = new ArrayList<Item>();
            }
            return this.item;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="PicUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="Url" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "title",
            "description",
            "picUrl",
            "url"
        })
        public static class Item {

            @XmlElement(name = "Title", required = true)
            protected String title;
            @XmlElement(name = "Description", required = true)
            protected String description;
            @XmlElement(name = "PicUrl", required = true)
            protected String picUrl;
            @XmlElement(name = "Url", required = true)
            protected String url;

            /**
             * Gets the value of the title property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTitle() {
                return title;
            }

            /**
             * Sets the value of the title property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTitle(String value) {
                this.title = value;
            }

            /**
             * Gets the value of the description property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDescription() {
                return description;
            }

            /**
             * Sets the value of the description property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDescription(String value) {
                this.description = value;
            }

            /**
             * Gets the value of the picUrl property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getPicUrl() {
                return picUrl;
            }

            /**
             * Sets the value of the picUrl property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setPicUrl(String value) {
                this.picUrl = value;
            }

            /**
             * Gets the value of the url property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUrl() {
                return url;
            }

            /**
             * Sets the value of the url property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUrl(String value) {
                this.url = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="MediaId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mediaId"
    })
    public static class Image {

        @XmlElement(name = "MediaId", required = true)
        protected String mediaId;

        /**
         * Gets the value of the mediaId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMediaId() {
            return mediaId;
        }

        /**
         * Sets the value of the mediaId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMediaId(String value) {
            this.mediaId = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="MusicUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="HQMusicUrl" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="ThumbMediaId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "title",
        "description",
        "musicUrl",
        "hqMusicUrl",
        "thumbMediaId"
    })
    public static class Music {

        @XmlElement(name = "Title", required = true)
        protected String title;
        @XmlElement(name = "Description", required = true)
        protected String description;
        @XmlElement(name = "MusicUrl", required = true)
        protected String musicUrl;
        @XmlElement(name = "HQMusicUrl", required = true)
        protected String hqMusicUrl;
        @XmlElement(name = "ThumbMediaId", required = true)
        protected String thumbMediaId;

        /**
         * Gets the value of the title property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTitle() {
            return title;
        }

        /**
         * Sets the value of the title property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTitle(String value) {
            this.title = value;
        }

        /**
         * Gets the value of the description property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription() {
            return description;
        }

        /**
         * Sets the value of the description property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription(String value) {
            this.description = value;
        }

        /**
         * Gets the value of the musicUrl property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMusicUrl() {
            return musicUrl;
        }

        /**
         * Sets the value of the musicUrl property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMusicUrl(String value) {
            this.musicUrl = value;
        }

        /**
         * Gets the value of the hqMusicUrl property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHQMusicUrl() {
            return hqMusicUrl;
        }

        /**
         * Sets the value of the hqMusicUrl property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHQMusicUrl(String value) {
            this.hqMusicUrl = value;
        }

        /**
         * Gets the value of the thumbMediaId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getThumbMediaId() {
            return thumbMediaId;
        }

        /**
         * Sets the value of the thumbMediaId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setThumbMediaId(String value) {
            this.thumbMediaId = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="KfAccount" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "kfAccount"
    })
    public static class TransInfo {

        @XmlElement(name = "KfAccount", required = true)
        protected String kfAccount;

        /**
         * Gets the value of the kfAccount property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getKfAccount() {
            return kfAccount;
        }

        /**
         * Sets the value of the kfAccount property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setKfAccount(String value) {
            this.kfAccount = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="MediaId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Title" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="Description" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mediaId",
        "title",
        "description"
    })
    public static class Video {

        @XmlElement(name = "MediaId", required = true)
        protected String mediaId;
        @XmlElement(name = "Title", required = true)
        protected String title;
        @XmlElement(name = "Description", required = true)
        protected String description;

        /**
         * Gets the value of the mediaId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMediaId() {
            return mediaId;
        }

        /**
         * Sets the value of the mediaId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMediaId(String value) {
            this.mediaId = value;
        }

        /**
         * Gets the value of the title property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTitle() {
            return title;
        }

        /**
         * Sets the value of the title property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTitle(String value) {
            this.title = value;
        }

        /**
         * Gets the value of the description property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDescription() {
            return description;
        }

        /**
         * Sets the value of the description property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDescription(String value) {
            this.description = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="MediaId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mediaId"
    })
    public static class Voice {

        @XmlElement(name = "MediaId", required = true)
        protected String mediaId;

        /**
         * Gets the value of the mediaId property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMediaId() {
            return mediaId;
        }

        /**
         * Sets the value of the mediaId property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMediaId(String value) {
            this.mediaId = value;
        }

    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "location_X",
            "location_Y",
            "scale",
            "label",
            "poiname"
    })
    public static class SendLocationInfo {

        @XmlElement(name = "Location_X", required = true)
        protected String location_X;
        @XmlElement(name = "Location_Y", required = true)
        protected String location_Y;
        @XmlElement(name = "Scale", required = true)
        protected String scale;
        @XmlElement(name = "Label", required = true)
        protected String label;
        @XmlElement(name = "Poiname", required = true)
        protected String poiname;

        /**
         * Gets the value of the locationX property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getLocation_X() {
            return location_X;
        }

        /**
         * Sets the value of the locationX property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setLocation_X(String value) {
            this.location_X = value;
        }

        /**
         * Gets the value of the locationY property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getLocation_Y() {
            return location_Y;
        }

        /**
         * Sets the value of the locationY property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setLocation_Y(String value) {
            this.location_Y = value;
        }

        /**
         * Gets the value of the scale property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getScale() {
            return scale;
        }

        /**
         * Sets the value of the scale property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setScale(String value) {
            this.scale = value;
        }

        /**
         * Gets the value of the label property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getLabel() {
            return label;
        }

        /**
         * Sets the value of the label property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setLabel(String value) {
            this.label = value;
        }

        /**
         * Gets the value of the poiname property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getPoiname() {
            return poiname;
        }

        /**
         * Sets the value of the poiname property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setPoiname(String value) {
            this.poiname = value;
        }

    }

}

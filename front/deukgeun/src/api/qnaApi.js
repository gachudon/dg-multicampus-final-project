import axios from "axios";

// export const API_SERVER_HOST = "http://localhost:8282";
// const prefix = `${API_SERVER_HOST}/api/qna`;
const prefix = `/api/qna`; // proxy 사용

export const registerInquery = async (formValues) => {
  try {
    const res = await axios.post(`${prefix}/register`, formValues);
    return res.data;
  } catch (error) {
    console.error("Error fetching qna data:", error);
    throw error;
  }
};

export const ListInquery = async () => {
  try {
    const res = await axios.get(`${prefix}/list`);
    console.log("queryList", res.data);
    return res.data;
  } catch (error) {
    console.error("Error fetching inquiries:", error);
    throw error;
  }
};

export const updateInquiry = async (editedInquiry) => {
  try {
    console.log("@@@editedInquiry", editedInquiry);
    const res = await axios.put(
      `${prefix}/update/${editedInquiry.qnaId}`,
      editedInquiry
    );
    return res.data; // Assuming your API returns updated inquiry data
  } catch (error) {
    console.error("Error updating inquiry:", error);
    throw error;
  }
};

export const deleteInquiryApi = async (inquiryId) => {
  try {
    const res = await axios.delete(`${prefix}/delete/${inquiryId}`);
    return res.data; // Assuming your API returns confirmation of deletion
  } catch (error) {
    console.error("Error deleting inquiry:", error);
    throw error;
  }
};

export const sendRegiNotiEmail = async (inquiry) => {
  try {
    const res = await axios.post(`${prefix}/sendRegiEmail`, inquiry);
    return res.data; // Assuming your API returns confirmation of deletion
  } catch (error) {
    console.error("Error sending regsitration email:", error);
    throw error;
  }
};

export const sendReplyNotiEmail = async (inquiry) => {
  try {
    const res = await axios.post(`${prefix}/sendReplyEmail`, inquiry);
    return res.data; // Assuming your API returns confirmation of deletion
  } catch (error) {
    console.error("Error sending reply email:", error);
    throw error;
  }
};

import React, { useEffect } from 'react';
import axios from 'axios';

const Payment = ({ userData, selectedPeriod, handleModify }) => {
  useEffect(() => {
    const jquery = document.createElement("script");
    jquery.src = "http://code.jquery.com/jquery-1.12.4.min.js";
    const iamport = document.createElement("script");
    iamport.src = "http://cdn.iamport.kr/js/iamport.payment-1.1.7.js";
    document.head.appendChild(jquery);
    document.head.appendChild(iamport);
    return () => {
      document.head.removeChild(jquery);
      document.head.removeChild(iamport);
    };
  }, []);

  const requestPay = () => {
    const { IMP } = window;
    IMP.init('가맹점식별코드');

    IMP.request_pay({
      pg: '{PG사코드}.{PG상점ID}',
      pay_method: 'card',
      merchant_uid: new Date().getTime(),
      name: '테스트 상품',
      amount: 1004,
      buyer_email: userData.email,
      buyer_name: userData.userName,
      buyer_tel: '010-1234-5678',
      buyer_addr: userData.address,
      buyer_postcode: '123-456',
    }, async (rsp) => {
      try {
        const { data } = await axios.post('http://localhost:8282/verifyIamport/' + rsp.imp_uid);
        if (rsp.paid_amount === data.response.amount) {
          alert('결제 성공');
          handleModify(); // 결제 성공 시 회원 정보 수정 처리
        } else {
          alert('결제 실패');
        }
      } catch (error) {
        console.error('Error while verifying payment:', error);
        alert('결제 실패');
      }
    });
  };

  return (
    <div>
      <button onClick={requestPay}>결제하기</button>
    </div>
  );
};

export default Payment;

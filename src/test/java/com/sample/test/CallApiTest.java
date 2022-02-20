package com.sample.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.dto.ZipCodeDataDto;
import com.sample.dto.ZipCodeDto;
import com.sample.service.ZipCodeService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZipCodeService.class)
public class CallApiTest {

	@Autowired
	ZipCodeService zipCodeService;

	/**
	 * getAdressTest1：テストを実行して、APIが意図した通りの値である事を検証する(動確用)
	 * @throws Exception
	 */
	@Test
	public void getAdressTest1() throws Exception {

		// 1. リクエストを作成
		String zipCode = "810-0001";
	
		// 2. API実行
		ZipCodeDto zipCodeDto = zipCodeService.zipcodeConfirm(zipCode);
		ZipCodeDataDto actual = zipCodeDto.getResults().get(0);
		
		// 実測値を表示(おまけ)
		System.out.println("------------------------------");
		System.out.println(actual.toString());
	
		// 3. APIレスポンスの検証
		assertEquals("福岡県", actual.getAddress1());
		assertEquals("福岡市中央区", actual.getAddress2());
		assertEquals("天神", actual.getAddress3());
		assertEquals("ﾌｸｵｶｹﾝ", actual.getKana1());
		assertEquals("ﾌｸｵｶｼﾁｭｳｵｳｸ", actual.getKana2());
		assertEquals("ﾃﾝｼﾞﾝ", actual.getKana3());
	}

	/**
	 * getAdressTest2：APIからのレスポンスが正しいと仮定して、期待値を正しい値に修正する
	 * @throws Exception
	 */
	@Test
	public void getAdressTest2() throws Exception {
	
		// 1. リクエストを作成
		String zipCode = "101-0051";
	
		// 2. API実行
		ZipCodeDto zipCodeDto = zipCodeService.zipcodeConfirm(zipCode);
		ZipCodeDataDto actual = zipCodeDto.getResults().get(0);
		
		// 実測値を表示(おまけ)
		System.out.println("------------------------------");
		System.out.println(actual.toString());
	
		// 3. APIレスポンスの検証
		assertEquals("東京都", actual.getAddress1());
		assertEquals("福岡市中央区", actual.getAddress2());
		assertEquals("神田神保町", actual.getAddress3());
		assertEquals("ﾌｸｵｶｹﾝ", actual.getKana1());
		assertEquals("ﾌｸｵｶｼﾁｭｳｵｳｸ", actual.getKana2());
		assertEquals("ﾃﾝｼﾞﾝ", actual.getKana3());
	}

	/**
	 * getAdressTest3：APIに複数郵便番号を渡して、複数件レスポンスが取得できることを確認する
	 * @throws Exception
	 */
	@Test
	public void getAdressTest3() throws Exception {
		// 1. リクエストを作成
		String zipCode1 = "xxx-xxxx";
		String zipCode2 = "yyy-yyyy";
	}
}
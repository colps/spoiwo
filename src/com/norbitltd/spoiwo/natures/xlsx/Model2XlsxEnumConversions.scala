package com.norbitltd.spoiwo.natures.xlsx

import org.apache.poi.ss.usermodel
import com.norbitltd.spoiwo.model.CellBorderStyle
import org.apache.poi.ss.usermodel.{FontCharset, BorderStyle}
import com.norbitltd.spoiwo.model.enums.{Charset, FontFamily, Underline, FontScheme}

object Model2XlsxEnumConversions {

  def convertBorderStyle(borderStyle: CellBorderStyle): BorderStyle = {
    import CellBorderStyle._
    import BorderStyle._

    borderStyle match {
      case DashDot => DASH_DOT
      case DashDotDot => DASH_DOT_DOT
      case Dashed => DASHED
      case Dotted => DOTTED
      case Double => DOUBLE
      case Hair => HAIR
      case Medium => MEDIUM
      case MediumDashDot => MEDIUM_DASH_DOT
      case MediumDashDotDot => MEDIUM_DASH_DOT_DOTC
      case None => NONE
      case SlantedDashDot => SLANTED_DASH_DOT
      case Thick => THICK
      case Thin => THIN
      case CellBorderStyle(id) =>
        throw new Exception("Unsupported option for XLSX conversion with id=%d".format(id))
    }
  }

  def convertCharset(charset : Charset): usermodel.FontCharset = {
    import Charset._
    import usermodel.FontCharset._

    charset match {
      case Charset.ANSI => FontCharset.ANSI
      case Arabic => ARABIC
      case Baltic => BALTIC
      case ChineseBig5 => CHINESEBIG5
      case Default => DEFAULT
      case EastEurope => EASTEUROPE
      case Charset.GB2312 => FontCharset.GB2312
      case Greek => GREEK
      case Hangeul => HANGEUL
      case Hebrew => HEBREW
      case Johab => JOHAB
      case Mac => MAC
      case Charset.OEM => FontCharset.OEM
      case Russian => RUSSIAN
      case ShiftJIS => SHIFTJIS
      case Symbol => SYMBOL
      case Thai => THAI
      case Turkish => TURKISH
      case Vietnamese => VIETNAMESE
      case Charset(value) =>
        throw new Exception(s"Unable to convert Charset=$value to XLSX - unsupported enum!")
    }
  }

  def convertFontFamily(fontFamily: FontFamily): usermodel.FontFamily = {
    import FontFamily._
    import usermodel.FontFamily._

    fontFamily match {
      case NotApplicable => NOT_APPLICABLE
      case Roman => ROMAN
      case Swiss => SWISS
      case Modern => MODERN
      case Script => SCRIPT
      case Decorative => DECORATIVE
      case FontFamily(value: String) =>
        throw new IllegalArgumentException(s"Unable to convert FontFamily=$value to XLSX - unsupported enum!")

    }
  }

  def convertFontScheme(fontScheme: FontScheme): usermodel.FontScheme = {
    import FontScheme._
    import usermodel.FontScheme._

    fontScheme match {
      case None => NONE
      case Major => MAJOR
      case Minor => MINOR
      case FontScheme(value: String) =>
        throw new IllegalArgumentException(s"Unable to convert FontScheme=$value to XLSX - unsupported enum!")
    }
  }

  def convertUnderline(underline: Underline): usermodel.FontUnderline = {
    import Underline._
    import usermodel.FontUnderline._

    underline match {
      case Double => DOUBLE
      case DoubleAccounting => DOUBLE_ACCOUNTING
      case None => NONE
      case Single => SINGLE
      case SingleAccounting => SINGLE_ACCOUNTING
      case Underline(value: String) =>
        throw new IllegalArgumentException(s"Unable to convert Underline=$value to XLSX - unsupported enum!")
    }
  }
}
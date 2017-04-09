package eg.edu.alexu.csd.datastructure.linkedList.cs70;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

/**
 * The Class PolynomialSolver.
 */
public class PolynomialSolver implements IPolynomialSolver {

  /** The Acoff.*/
  private OurSingleLinked acoff = new OurSingleLinked();
  /** The Aexp.*/
  private OurSingleLinked aexp = new OurSingleLinked();
  /** The Bcoff.*/
  private OurSingleLinked bcoff = new OurSingleLinked();
  /** The Bexp.*/
  private OurSingleLinked bexp = new OurSingleLinked();
  /** The Ccoff.*/
  private OurSingleLinked ccoff = new OurSingleLinked();
  /** The Cexp.*/
  private OurSingleLinked cexp = new OurSingleLinked();
  /** The Rcoff.*/
  private OurSingleLinked rcoff = new OurSingleLinked();
  /** The Rexp.*/
  private OurSingleLinked rexp = new OurSingleLinked();
  /** The tmpexp.*/
  private OurSingleLinked tmpexp = new OurSingleLinked();
  /** The tmp coff.*/
  private OurSingleLinked tmpcoff = new OurSingleLinked();
  /** The operation.*/
  private boolean operation = false;
  /**The checker.*/
  final int checker = 10000;

  /**
   * Set polynomial terms (coefficients & exponents).
   * @param poly
   *          name of the polynomial.
   * @param terms
   *          array of [coefficients][exponents].
   */
  @Override
  public void setPolynomial(final char poly, final int[][] terms) {
    int checker1 = checker;
    switch (poly) {
      case 'A':
        if (!aexp.isEmpty()) {
          throw new RuntimeException("Check Set A ");
        }
        for (int i = 0; i < terms.length; i++) {
          acoff.add(terms[i][0]);
          if (checker1 > terms[i][1] && terms[i][1] > -1) {
            aexp.add(terms[i][1]);
            checker1 = terms[i][1];
          } else {
            throw new RuntimeException("Check Set A ");
          }
        }
        break;
      case 'B':
        if (!bexp.isEmpty()) {
          throw new RuntimeException("Check Set A ");
        }
        for (int i = 0; i < terms.length; i++) {
          bcoff.add(terms[i][0]);
          if (checker1 > terms[i][1] && terms[i][1] > -1) {
            bexp.add(terms[i][1]);
            checker1 = terms[i][1];
          } else {
            throw new RuntimeException("Check Set B ");
          }
        }
        break;
      case 'C':
        if (!cexp.isEmpty()) {
          throw new RuntimeException("Check Set A ");
        }
        for (int i = 0; i < terms.length; i++) {
          ccoff.add(terms[i][0]);
          if (checker1 > terms[i][1] && terms[i][1] > -1) {
            cexp.add(terms[i][1]);
            checker1 = terms[i][1];
          } else {
            throw new RuntimeException("Check Set C ");
          }
        }
        break;
      case 'R':
        rexp.clear();
        rcoff.clear();
        if (operation) {
          for (int i = 0; i < terms.length; i++) {
            rcoff.add(terms[i][0]);
            if (checker1 > terms[i][1] && terms[i][1] > -1) {
              rexp.add(terms[i][1]);
              checker1 = terms[i][1];
            } else {
              throw new RuntimeException("Check Set R ");
            }
          }
        } else {
          throw new RuntimeException("Can't Set R ");
        }
        break;
      default:
        checker1++;
        throw new RuntimeException("Check Set ");
    }
  }

  /**
   * Print the polynomial in human readable representation.
   * @param poly
   *          name of the polynomial.
   * @return polynomial in the form like 27x^2+x-1.
   */
  @Override
  public String print(final char poly) {
    int[][] array;
    switch (poly) {
      case 'A':
        if (acoff.isEmpty()) {
          return null;
        }
        array = toArray(acoff, aexp);
        return printpoly(array);
      case 'B':
        if (bcoff.isEmpty()) {
          return null;
        }
        array = toArray(bcoff, bexp);
        return printpoly(array);
      case 'C':
        if (ccoff.isEmpty()) {
          return null;
        }
        array = toArray(ccoff, cexp);
        return printpoly(array);
      case 'R':
        if (rcoff.isEmpty()) {
          return null;
        }
        array = toArray(rcoff, rexp);
        return printpoly(array);
      default:
        break;
    }
    return null;
  }

  /**
   * Clear the polynomial.
   * @param poly
   *          name of the polynomial.
   */
  @Override
  public void clearPolynomial(final char poly) {
    switch (poly) {
      case 'A':
        if (!aexp.isEmpty()) {
          aexp.clear();
          acoff.clear();
        } else {
          throw new RuntimeException("Check Clear");
        }
        break;
      case 'B':
        if (!bexp.isEmpty()) {
          bexp.clear();
          bcoff.clear();
        } else {
          throw new RuntimeException("Check Clear");
        }
        break;
      case 'C':
        if (!cexp.isEmpty()) {
          cexp.clear();
          ccoff.clear();
        } else {
          throw new RuntimeException("Check Clear");
        }
        break;
      default:
        break;
    }
  }

  /**
   * Evaluate the polynomial.
   * @param poly
   *          name of the polynomial.
   * @param value
   *        polynomial constant value.
   * @return the value of the polynomial.
   */
  @Override
  public float evaluatePolynomial(final char poly, final float value) {
    float result = 0;
    switch (poly) {
      case 'A':
        if (!aexp.isEmpty()) {
          for (int i = 0; i < acoff.size(); i++) {
            result += (Float.valueOf(acoff.get(i).toString())
                * Math.pow(value, Float.valueOf(aexp.get(i).toString())));
          }
        } else {
          throw new RuntimeException("Check Evaluate");
        }
        break;
      case 'B':
        if (!bexp.isEmpty()) {
          for (int i = 0; i < bcoff.size(); i++) {
            result += (Float.valueOf(bcoff.get(i).toString())
                * Math.pow(value, Float.valueOf(bexp.get(i).toString())));
          }
        } else {
          throw new RuntimeException("Check Evaluate");
        }
        break;
      case 'C':
        if (!cexp.isEmpty()) {
          for (int i = 0; i < ccoff.size(); i++) {
            result += (Float.valueOf(ccoff.get(i).toString())
                * Math.pow(value, Float.valueOf(cexp.get(i).toString())));
          }
        } else {
          throw new RuntimeException("Check Evaluate");
        }
        break;
      default:
        throw new RuntimeException("Check Evaluate");
    }
    return result;
  }

  /**
   * Add two polynomials.
   * @param poly1
   *          first polynomial.
   * @param poly2
   *          second polynomial.
   * @return the result polynomial.
   */
  @Override
  public int[][] add(final char poly1, final char poly2) {
    if (poly1 == poly2) {
      int[][] array;
      if (poly1 == 'A' && !aexp.isEmpty()) {
        operation = true;
        array = toArray(acoff, aexp);
        setPolynomial('R', merge(array, array));
        operation = false;
        return merge(array, array);
      }
      if (poly1 == 'B' && !bexp.isEmpty()) {
        operation = true;
        array = toArray(bcoff, bexp);
        setPolynomial('R', merge(array, array));
        operation = false;
        return merge(array, array);
      }
      if (poly1 == 'C' && !cexp.isEmpty()) {
        operation = true;
        array = toArray(ccoff, cexp);
        setPolynomial('R', merge(array, array));
        operation = false;
        return merge(array, array);
      }
    } else {
      int[][] arrayOne;
      int[][] arrayTwo;
      if (poly1 == 'A' && !aexp.isEmpty()) {
        arrayOne = toArray(acoff, aexp);
        operation = true;
        if (poly2 == 'B') {
          arrayTwo = toArray(bcoff, bexp);
          setPolynomial('R', merge(arrayOne, arrayTwo));
          operation = false;
          return merge(arrayOne, arrayTwo);
        }
        if (poly2 == 'C') {
          arrayTwo = toArray(ccoff, cexp);
          setPolynomial('R', merge(arrayOne, arrayTwo));
          operation = false;
          return merge(arrayOne, arrayTwo);
        }
        if (poly2 == 'T') {
          arrayTwo = toArray(tmpcoff, tmpexp);
          setPolynomial('R', merge(arrayOne, arrayTwo));
          operation = false;
          return merge(arrayOne, arrayTwo);
        } else {
          throw new RuntimeException("No other parameter is not permitted");
        }
      } else if (poly1 == 'B' && !bexp.isEmpty()) {
        operation = true;
        arrayOne = toArray(bcoff, bexp);
        if (poly2 == 'A') {
          return add('A', 'B');
        }
        if (poly2 == 'C') {
          arrayTwo = toArray(ccoff, cexp);
          setPolynomial('R', merge(arrayOne, arrayTwo));
          operation = false;
          return merge(arrayOne, arrayTwo);
        } else if (poly2 == 'T') {
          arrayTwo = toArray(tmpcoff, tmpexp);
          setPolynomial('R', merge(arrayOne, arrayTwo));
          operation = false;
          return merge(arrayOne, arrayTwo);
        } else {
          throw new RuntimeException("No other parameter is not permitted");
        }
      } else if (poly1 == 'C' && !cexp.isEmpty()) {
        operation = true;
        arrayOne = toArray(ccoff, cexp);
        if (poly2 == 'A') {
          return add('A', 'C');
        }
        if (poly2 == 'B') {
          return add('B', 'C');
        }
        if (poly2 == 'T') {
          arrayTwo = toArray(tmpcoff, tmpexp);
          setPolynomial('R', merge(arrayOne, arrayTwo));
          operation = false;
          return merge(arrayOne, arrayTwo);
        }
      }
    }
    if (rexp.isEmpty()) {
      throw new RuntimeException("Check add ");
    }
    return null;
  }

  /**
   * Subtract two polynomials.
   * @param poly1
   *          first polynomial.
   * @param poly2
   *          second polynomial.
   * @return the result polynomial.
   */
  @Override
  public int[][] subtract(final char poly1, final char poly2) {
    if (poly1 == poly2) {
      operation = true;
      int[][] returnValue = new int[][] {{0, 0}};
      if (poly1 == 'A' && !aexp.isEmpty()) {
        setPolynomial('R', returnValue);
        operation = false;
        return returnValue;
      } else if (poly1 == 'B' && !bexp.isEmpty()) {
        setPolynomial('R', returnValue);
        operation = false;
        return returnValue;
      } else if (poly1 == 'C' && !cexp.isEmpty()) {
        setPolynomial('R', returnValue);
        operation = false;
        return returnValue;
      }
    } else {
      tmpexp.clear();
      tmpcoff.clear();
      operation = true;
      if (poly2 == 'A') {
        for (int i = 0; i < aexp.size(); i++) {
          tmpexp.add(Integer.valueOf(aexp.get(i).toString()));
          tmpcoff.add(-1 * Integer.valueOf(acoff.get(i).toString()));
        }
        operation = false;
        return add(poly1, 'T');
      } else if (poly2 == 'B') {
        for (int i = 0; i < bexp.size(); i++) {
          tmpexp.add(Integer.valueOf(bexp.get(i).toString()));
          tmpcoff.add(-1 * Integer.valueOf(bcoff.get(i).toString()));
        }
        operation = false;
        return add(poly1, 'T');

      } else if (poly2 == 'C') {
        for (int i = 0; i < cexp.size(); i++) {
          tmpexp.add(Integer.valueOf(cexp.get(i).toString()));
          tmpcoff.add(-1 * Integer.valueOf(ccoff.get(i).toString()));
        }
        operation = false;
        return add(poly1, 'T');
      }
    }
    return null;
  }

  /**
   * Multiply two polynomials.
   * @param poly1
   *          first polynomial.
   * @param poly2
   *          second polynomial.
   * @return the result polynomial.
   */
  @Override
  public int[][] multiply(final char poly1, final char poly2) {
    int[][] arrayOne;
    int[][] arrayTwo;
    if (poly1 == 'A' && poly2 == 'B' || poly1 == 'B' && poly2 == 'A') {
      operation = true;
      arrayOne = toArray(acoff, aexp);
      arrayTwo = toArray(bcoff, bexp);
      setPolynomial('R', multi(arrayOne, arrayTwo));
      operation = false;
      return multi(arrayOne, arrayTwo);
    }
    if (poly1 == 'A' && poly2 == 'C' || poly1 == 'C' && poly2 == 'A') {
      operation = true;
      arrayOne = toArray(acoff, aexp);
      arrayTwo = toArray(ccoff, cexp);
      setPolynomial('R', multi(arrayOne, arrayTwo));
      operation = false;
      return multi(arrayOne, arrayTwo);
    }
    if (poly1 == 'B' && poly2 == 'C' || poly1 == 'C' && poly2 == 'B') {
      operation = true;
      arrayOne = toArray(ccoff, cexp);
      arrayTwo = toArray(bcoff, bexp);
      setPolynomial('R', multi(arrayOne, arrayTwo));
      operation = false;
      return multi(arrayOne, arrayTwo);
    }
    if (poly1 == poly2) {
      operation = true;
      switch (poly1) {
        case 'A':
          arrayOne = toArray(acoff, aexp);
          setPolynomial('R', multi(arrayOne, arrayOne));
          operation = false;
          return multi(arrayOne, arrayOne);
        case 'B':
          arrayTwo = toArray(bcoff, bexp);
          setPolynomial('R', multi(arrayTwo, arrayTwo));
          operation = false;
          return multi(arrayTwo, arrayTwo);
        case 'C':
          arrayOne = toArray(ccoff, cexp);
          setPolynomial('R', multi(arrayOne, arrayOne));
          operation = false;
          return multi(arrayOne, arrayOne);
        default:
          throw new RuntimeException("Not valid");
      }
    }
    return null;
  }

  /**
   * Merge.
   * @param poly1
   *          the poly1.
   * @param poly2
   *          the poly2.
   * @return the int[][].
   */
  private int[][] merge(final int[][] poly1, final int[][] poly2) {
    int i0 = 0;
    int j0 = 0;
    int k0 = 0;
    int[][] tmp = new int[poly1.length + poly2.length][2];
    while (i0 < poly1.length && j0 < poly2.length) {
      if (poly1[i0][1] < poly2[j0][1]) {
        tmp[k0][1] = poly2[j0][1];
        tmp[k0][0] = poly2[j0][0];
        k0++;
        j0++;
      } else if (poly1[i0][1] > poly2[j0][1]) {
        tmp[k0][1] = poly1[i0][1];
        tmp[k0][0] = poly1[i0][0];
        k0++;
        i0++;

      } else {
        tmp[k0][1] = poly1[i0][1];
        tmp[k0][0] = poly2[j0][0] + poly1[i0][0];
        i0++;
        j0++;
        k0++;
      }
    }
    while (i0 < poly1.length) {
      tmp[k0][1] = poly1[i0][1];
      tmp[k0][0] = poly1[i0][0];
      k0++;
      i0++;
    }
    while (j0 < poly2.length) {
      tmp[k0][1] = poly2[j0][1];
      tmp[k0][0] = poly2[j0][0];
      k0++;
      j0++;
    }
    int[][] result = new int[k0][2];
    for (i0 = 0; i0 < k0; i0++) {
      if (tmp[i0][0] != 0) {
        result[i0][0] = tmp[i0][0];
        result[i0][1] = tmp[i0][1];
      }
    }
    if (result[0][0] == 0) {
      return new int[][] {{0, 0}};
    }
    return result;
  }

  /**
   * Printpoly.
   * @param poly
   *          the poly.
   * @return the string.
   */
  private String printpoly(final int[][] poly) {
    String message = new String();
    if (poly.length == 1 && poly[0][0] == 0) {
      return "0";
    }
    for (int i = 0; i < poly.length; i++) {
      if (poly[i][0] == 0) {
        continue;
      }
      if ((poly[i][0] != 1 && poly[i][0] != -1) || poly[i][1] == 0) {
        message += poly[i][0];
      } else if (poly[i][0] == -1) {
        message += "-";
      }
      if (poly[i][1] != 0) {
        if (poly[i][1] == 1) {
          message += "x";
        } else {
          message += "x^" + poly[i][1];
        }
        if (i + 1 != poly.length) {
          if (poly[i + 1][0] != 1 || poly[i + 1][0] != -1) {
            if (poly[i + 1][0] > 0) {
              message += "+";
            }
          }
        }
      }
    }
    return message;
  }

  /**
   * Multi.
   * @param poly1
   *          the first poly.
   * @param poly2
   *          the second poly.
   * @return the array.
   */
  private int[][] multi(final int[][] poly1, final int[][] poly2) {
    int icounter;
    int j0;
    final int x1000000 = 1000000;
    final int x0 = 0;
    int[] array = new int[x1000000];
    for (icounter = 0; icounter < poly1.length; icounter++) {
      for (j0 = 0; j0 < poly2.length; j0++) {
        array[poly1[icounter][1] + poly2[j0][1]]
            += poly1[icounter][0] * poly2[j0][0];
      }
    }
    for (icounter = poly1[0][1] + poly2[0][1], j0 = 0;
        icounter >= poly1[poly1.length - 1][1]
        + poly2[poly2.length - 1][1]; icounter--) {
      if (array[icounter] != 0) {
        j0++;
      }
    }
    if (j0 == 0) {
      return new int[][] {{x0, x0}};
    }
    int[][] result = new int[j0][2];
    for (icounter = poly1[0][1] + poly2[0][1], j0 = 0;
        icounter >= poly1[poly1.length - 1][1]
        + poly2[poly2.length - 1][1]; icounter--) {
      if (array[icounter] != 0) {
        result[j0][0] = array[icounter];
        result[j0][1] = icounter;
        j0++;
      }
    }
    return result;
  }

  /**
   * To array.
   * @param alist
   *          the alist.
   * @param blist
   *          the blist.
   * @return the int[][].
   */
  private int[][] toArray(final OurSingleLinked alist,
      final OurSingleLinked blist) {
    int[][] result = new int[alist.size()][2];
    for (int i = 0; i < alist.size(); i++) {
      result[i][1] = Integer.valueOf(blist.get(i).toString());
      result[i][0] = Integer.valueOf(alist.get(i).toString());
    }
    return result;
  }

  /**
   * Checks if is valid.
   * @param poly
   *          the poly.
   * @return true, if is valid.
   */
  public boolean isValid(final char poly) {
    if (poly == 'A') {
      if (!aexp.isEmpty()) {
        return true;
      }
    }
    if (poly == 'B') {
      if (!bexp.isEmpty()) {
        return true;
      }
    }
    if (poly == 'C') {
      if (!cexp.isEmpty()) {
        return true;
      }
    }
    if (poly == 'R') {
      if (!rexp.isEmpty()) {
        return true;
      }
    }
    return false;
  }
}

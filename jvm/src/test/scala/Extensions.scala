/*
 * Copyright 2022 quafadas
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

//import viz.extensions.jvm.*
//import viz.PlotTargets.websocket // for local testing
import viz.PlotTargets.doNothing // for CI... as we don't have a port available...
import scala.util.Random

class ExtensionSuiteJVM extends munit.FunSuite:
  test("extension methods exist... ") {

    val randomTuple_Int_Double: IndexedSeq[(Int, Double)] = (0 to 20).map(i => (i, i * Random.nextDouble()))
    //randomTuple_Int_Double.plotRegression()

  }
